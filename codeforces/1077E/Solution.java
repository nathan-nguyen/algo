import java.util.*;

public class Solution {
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        int n = in.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int a = in.nextInt();
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int k: map.keySet()) list.add(k);

        list.sort((u, v) -> map.get(v) - map.get(u));
        int result = 0, min = 0, count = 2;
        
        for (int i: list) {
//            System.out.println(result + " " + min + " " + count);
            int k = map.get(i);
            if (result == 0) {
                result = k;
                min = k;
            } else if (k * 2 >= min) {
                result = Math.max(result, (min / 2) * ((1 << count) - 1));
                ++count;
                min = min  / 2;
            }
        }
        System.out.println(result);
    }
}

