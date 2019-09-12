import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int zero = 1, one = 1;
        for (int i = 2; i <= n; ++i) {
            int nextZero = zero + one;
            int nextOne = zero;
            zero = nextZero;
            one = nextOne;
        }
        System.out.println(zero + one);
    }
}
