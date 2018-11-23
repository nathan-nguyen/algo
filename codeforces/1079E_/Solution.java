import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int total = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            total += a[i];
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        
        int[][] dp = new int[n+1][total+1];

        for (int key: map.keySet()) {
            ++dp[1][key];
            for (int i = 1; i <= n; ++i) {
                for (int j = key + 1; j <= total; ++j) {
                    dp[i][j] += dp[i-1][j - key];
                    dp[i][j] = Math.min(dp[i][j], 2);
                }
            }
        }
        int max = 0;
        for (int key: map.keySet()) {
            for (int i = map.get(key); i > 0; --i) {
                System.out.println(key + " " + i + " " + dp[i][i * key]);
                if (dp[i][i * key] == 1) {
                    if (map.keySet().size() == 2 && i == map.get(key)) {
                        System.out.println(n);
                        return;
                    }
                    max = Math.max(max, i);
                }
            }
        }
        System.out.println(max);
    }
}
