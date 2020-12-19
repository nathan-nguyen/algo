import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve());
    }

    private long solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; ++i) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }

        Arrays.sort(a, (u, v) -> Integer.compare(u[0], v[0]));
        int left = 0, right = 0;
        long sum = 0, max = 0;
        while (right < n) {
            while (right < n && a[left][0] + d > a[right][0]) sum += a[right++][1];
            max = Math.max(max, sum);
            if (right == n) return max;
            else sum -= a[left++][1];
        }
        return max;
    }
}
