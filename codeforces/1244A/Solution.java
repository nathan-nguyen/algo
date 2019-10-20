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
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int k = in.nextInt();

            int x = f(a, c);
            int y = f(b, d);
            if (x + y > k) {
                System.out.println(-1);
                continue;
            }
            System.out.println(x + " " + y);
        }
    }

    private int f(int x, int y) {
        if (x % y == 0) return x / y;
        else return x / y + 1;
    }
}
