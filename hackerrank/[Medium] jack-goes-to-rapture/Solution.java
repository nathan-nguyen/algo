import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve());
    }

    private long solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<List<Integer>> edge = new ArrayList<>(); 
        for (int i = 0; i < n; ++i) edge.add(new ArrayList<>());
        Map<String, Integer> map = new HashMap<>();

        while (m -- > 0) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int c = in.nextInt();
            edge.get(a).add(b);
            edge.get(b).add(a);
            String k1 = a + "_" + b;
            String k2 = b + "_" + a;
            map.put(k1, Math.min(map.getOrDefault(k1, Integer.MAX_VALUE), c));
            map.put(k2, Math.min(map.getOrDefault(k2, Integer.MAX_VALUE), c));
        }

return 0;
    }

}
