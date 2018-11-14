import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T -- > 0) {
            long n = in.nextLong();
            int k = in.nextInt();
            long count = 0;
            for (int i = 0; i < n; ++i) {
                if (in.nextInt() == k) ++count;
            }

            if (count < 3) {
                System.out.println(0);
                continue;
            }

            if (count == n) {
                System.out.print(1);
                continue;
            }

            long first = count * (count - 1) * (count - 2);
            long second = n * (n - 1) * (n - 2);
            long gcdResult = gcd(first, second);
            System.out.println((first / gcdResult) + "/" + (second / gcdResult));
        }
    }

    private long gcd(long a, long b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

}
