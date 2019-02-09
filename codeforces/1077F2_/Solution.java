import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();

        long[][] dp = new long[n][m+1];
        for (int i = 0; i < n && i < d; ++i) dp[i][1] = a[i];

        for (int j = 2; j <= m; ++j) {
            final int k = j - 1;
            Queue<Integer> queue = new PriorityQueue<>((u, v) -> Long.compare(dp[v][k], dp[u][k]));
            for (int i = 0; i < n; ++i) {
                while (queue.size() > 0 && (queue.peek() < i - d || dp[queue.peek()][k] == 0)) queue.poll();
                if (queue.size() > 0) dp[i][j] = dp[queue.peek()][j-1] + a[i];
                queue.offer(i);
            }
        }
        long max = 0;
        for (int i = n - 1; i >= 0 && i >= n - d; --i) max = Math.max(max, dp[i][m]);
        System.out.println(max == 0 ? -1 : max);
    }
}

