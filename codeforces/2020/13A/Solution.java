import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int up = 0, down = n - 2;

        for (int i = 2; i < n; ++i) up += calculate(n, i);
        int k = gcd(up, down);

        System.out.println((up / k) + "/" + (down / k));
    }

    private int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    private int calculate(int n, int b) {
        int total = 0;
        while (n != 0) {
            total += n % b;
            n /= b;
        }
        return total;
    }
}
