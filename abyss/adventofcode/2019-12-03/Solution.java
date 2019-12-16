import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void updateMap(Map<String, Integer> map, int[] position, int d, int x, int y) {
        for (int i = 0; i <= d; ++i) {
            String key = (position[0] + i * x) + " " + (position[1] + i * y);
            if (!map.containsKey(key)) map.put(key, position[2] + i);
        }
        position[0] += d * x;
        position[1] += d * y;
        position[2] += d;
    }

    private int secondWireIntersectMin(Map<String, Integer> map, int[] position, int d, int x, int y) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= d; ++i) {
            String key = (position[0] + i * x) + " " + (position[1] + i * y);
            if (map.containsKey(key)) min = Math.min(min, position[2] + i + map.get(key));
        }
        position[0] += d * x;
        position[1] += d * y;
        position[2] += d;
        return min;
    }

    private void solve() {
        Scanner in = new Scanner(System.in);

        Map<String, Integer>  map = new HashMap<>();
        String[] s1 = in.next().split(",");
        int[] position = new int[]{0, 0, 0};
        for (String s: s1) {
            int d = Integer.parseInt(s.substring(1));
            if (s.charAt(0) == 'R') updateMap(map, position, d, 1, 0);
            else if (s.charAt(0) == 'L') updateMap(map, position, d, -1, 0);
            else if (s.charAt(0) == 'U') updateMap(map, position, d, 0, 1);
            else if (s.charAt(0) == 'D') updateMap(map, position, d, 0, -1);
        }
        map.remove("0 0");

        position = new int[]{0, 0, 0};
        String[] s2 = in.next().split(",");
        int min = Integer.MAX_VALUE;
        for (String s: s2) {
            int d = Integer.parseInt(s.substring(1));
            if (s.charAt(0) == 'R') min = Math.min(min, secondWireIntersectMin(map, position, d, 1, 0));
            else if (s.charAt(0) == 'L') min = Math.min(min, secondWireIntersectMin(map, position, d, -1, 0));
            else if (s.charAt(0) == 'U') min = Math.min(min, secondWireIntersectMin(map, position, d, 0, 1));
            else if (s.charAt(0) == 'D') min = Math.min(min, secondWireIntersectMin(map, position, d, 0, -1));
        }
        System.out.println(min);
    }
}

