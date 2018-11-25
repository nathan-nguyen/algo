import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private static final int MOD = 1000_000_007;

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long x = in.nextInt();
        long y = in.nextInt();
        long cost = 0;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; ++i) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }

        Arrays.sort(a, (u, v) -> Integer.compare(u[0], v[0]));

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] rg: a) {
            if (map.isEmpty()) cost = (cost + (rg[1] - rg[0]) * y + x) % MOD;
            else {
                Integer k = map.floorKey(rg[0] - 1);
                if (k == null || (y * (rg[0] - k) >= x)) cost = (cost + (rg[1] - rg[0]) * y + x) % MOD;
                else {
                    if (map.get(k) == 1) map.remove(k);
                    else map.put(k, map.get(k) - 1);
                    cost = (cost + (rg[1] - k) * y) % MOD;
                }
            }
            map.put(rg[1], map.getOrDefault(rg[1], 0) + 1);
        }

        System.out.println(cost);
    }
}
