import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t -- > 0) {
            int n = in.nextInt();
            int ma = Integer.MAX_VALUE;
            int mb = Integer.MAX_VALUE;
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
                ma = Math.min(ma, a[i]);
            }
            for (int i = 0; i < n; ++i) {
                b[i] = in.nextInt();
                mb = Math.min(mb, b[i]);
            }
            long result = 0;
            for (int i = 0; i < n; ++i) {
                result += Math.max(a[i] - ma, b[i] - mb);
            }
            System.out.println(result);
        }
    }
}
