import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = s * 2 - 1;
        int m = n * 2 - 1;

        char[][] a = new char[n][m];
        for (int i = 0; i < n; ++i) Arrays.fill(a[i], '-');

        for (int i = 0; i < n; ++i) {
            char start = (char)('a' + Math.abs(s - 1 - i));
            for (int j = 0; j <= m / 2 && start < 'a' + s; j += 2) {
                a[i][m / 2 - j] = start;
                a[i][m / 2 + j] = start;
                ++start;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) System.out.print(a[i][j]);
            System.out.println();
        }
    }
}

