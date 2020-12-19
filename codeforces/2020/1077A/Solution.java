import java.util.Scanner;

public class Solution {
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        int t = in.nextInt();
        while (t -- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            long k = in.nextInt();
            System.out.println(- k / 2 * b + (k - k / 2) * a);
        } 
    }
}

