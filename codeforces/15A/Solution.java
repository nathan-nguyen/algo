import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();

        int[][] a = new int[n][2];
        for (int i = 0; i < n; ++i) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }

        Arrays.sort(a, (u, v) -> Integer.compare(u[0], v[0]));

        int result = 2;
        for (int i = 1; i < n; ++i) {
            if (2 * a[i][0] - a[i][1] - 2 * a[i-1][0] - a[i-1][1] == 2 * t) ++result;
            else if (2 * a[i][0] - a[i][1] - 2 * a[i-1][0] - a[i-1][1] > 2 * t) result += 2;
        }

        System.out.println(result);
    }
}