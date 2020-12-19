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
            String s = in.next();

            System.out.println(solve(n, s));
        }
    }

    private int solve(int n, String s) {
        int max = n;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') {
                max = Math.max(max, 2 * (i + 1));
                max = Math.max(max, 2 * (n - i));
            }
        }
        return max;
    }
}
