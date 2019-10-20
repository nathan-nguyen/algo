import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve());
    }

    private String solve() {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long p = in.nextLong();
        long w = in.nextLong();
        long d = in.nextLong();

        if (p % gcd(w, d) != 0) return "-1";

        long start = Math.max(0, (p - d * n) / (w - d));
        long end = p / w;

        for (long x = end; x >= start; --x) {
            if (x + (p - w * x) / d > n) return "-1";

            if ((p - w * x) %  d == 0) {
                long y = (p - w * x) / d;
                return (x + " " + y + " " + (n - x - y));
            }
        }
        return "-1";
    }

    private long gcd(long a, long b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
