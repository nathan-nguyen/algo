import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();

        long[][] dp = new long[n][x+1];
        for (int i = 0; i < n; ++i) Arrays.fill(dp[i], Long.MIN_VALUE);
        for (int i = 0; i < k; ++i) dp[i][1] = a[i];

        for (int j = 2; j <= x; ++j) {
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                if (!deque.isEmpty() && dp[deque.peekFirst()][j-1] != Long.MIN_VALUE) dp[i][j] = Math.max(dp[i][j], dp[deque.peekFirst()][j-1] + a[i]);
                while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
                while (!deque.isEmpty() && dp[deque.peekLast()][j - 1] <= dp[i][j - 1]) deque.pollLast();
                deque.offerLast(i);
            }
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < k; ++i) max = Math.max(max, dp[n - 1 - i][x]);
        System.out.println(max == Long.MIN_VALUE ? -1 : max);
    }
}
