import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new  Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t -- > 0) {
            long n = in.nextLong();
            long k = in.nextLong();

            System.out.println(solve(n, k));
        }
    }

    private String solve(long n, long k) {
        if (n > 31) return "YES " + (n - 1);
        if (k > f(n)) return "NO";

        long square = 1;
        long splitDone = 0;
        long size = n;
        long splitLeft = 0;
        
        while (splitDone + square <= k && size > 0) {
            splitDone += square;
            --size;
            splitLeft += (square * 2 - 1) * f(size);
            square = square * 2 + 1;
        }
        // System.out.println(square + " " + splitDone + " " + size + " " + splitLeft);
        if (k > splitDone + splitLeft) return "NO";
        else return "YES " + size;
    }

    private long f(long x) {
        return ((1L << (2 * x)) - 1) / 3;
    }
}
