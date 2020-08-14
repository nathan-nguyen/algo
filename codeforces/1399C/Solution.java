import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) a[i] = in.nextInt();
            int max = 0;
            for (int i = 2; i <= 100; ++i) max = Math.max(max, solve(n, a, i));
            System.out.println(max);
        }
    }

    private int solve(int n, int[] a, int k) {
        int result = 0;
        int[] m = new int[101];
        for (int e: a) ++m[e];
        for (int i = 1; i <= k / 2; ++i) {
            if (i * 2 == k) result += m[i] / 2;
            else result += Math.min(m[i], m[k - i]);
        }
        return result;
    }
}
