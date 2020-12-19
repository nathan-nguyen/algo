import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        long total = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            total += a[i];
        }

        if (total % 3 != 0) {
            System.out.println(0);
            return;
        }

        long result = 0, sum = 0;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            sum += a[i];
            if (sum == total * 2 / 3 && i > 0 && i < n - 1) result += count;
            if (sum == total / 3) ++count;
        }

        System.out.println(result);
    }
}
