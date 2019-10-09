import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[][] a = new int[q][2];

        int[] s = new int[5001];
        int total = 0;

        for (int i = 0; i < q; ++i) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
            for (int x = a[i][0]; x <= a[i][1]; ++x) {
                if (s[x] == 0) ++total;
                ++s[x];
            }
        }

        int max = 0;
        for (int i = 0; i < q; ++i) {
            int count = total;
            // Remove ith work
            for (int x = a[i][0]; x <= a[i][1]; ++x) {
                if (s[x] == 1) --count;
                --s[x];
            }
            // Build prefix sum
            int[] p = new int[5001];
            for (int x = 1; x < 5001; ++x) {
                if (s[x] == 1) p[x] = p[x-1] + 1;
                else p[x] = p[x-1];
            }
            for (int j = i + 1; j < q; ++j) max = Math.max(max, count - p[a[j][1]] + p[a[j][0] - 1]);
            // Add ith work
            for (int x = a[i][0]; x <= a[i][1]; ++x) ++s[x];
        }
        System.out.println(max);
    }
}