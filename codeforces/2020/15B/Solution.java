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
            int m = in.nextInt();
            int x1 = in.nextInt(), y1 = in.nextInt();
            int x2 = in.nextInt(), y2 = in.nextInt();
            long a = Math.max(x1, x2) - Math.min(x1, x2);
            long b = Math.max(y1, y2) - Math.min(y1, y2);
            if (2 * a <= n && 2 * b <= m) System.out.println(2 * a * b);
            else System.out.println(2 * a * b - (2 * a - n) * (2 * b - m));
        }
    }
}