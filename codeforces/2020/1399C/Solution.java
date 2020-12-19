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
            int[] m = new int[101];
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
                ++m[a[i]];
            }
            int max = 0;
            for (int i = 2; i <= 100; ++i) max = Math.max(max, solve(m, i));
            System.out.println(max);
        }
    }

    private int solve(int[] m, int k) {
        int result = 0;
        for (int i = 1; i < k / 2; ++i) result += Math.min(m[i], m[k - i]);
        if (k % 2 == 0) result += m[k / 2] / 2;
        else result += Math.min(m[k / 2], m[k - k / 2]);
        return result;
    }
}
