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
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            System.out.println(check(a, b, c) ? "YES" : "NO");
        }
    }

    private boolean check(long a, long b, long c) {
        if ((a + b + c) % 9 != 0) return false; 
        long n = (a + b + c) / 9;
        return a >= n && b >= n && c >= n;
    }
}
