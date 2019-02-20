import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve());
    }

    private int solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] x =  new int[n];
        int[] h = new int[n];

        for (int i = 0; i < n; ++i) {
            x[i] = in.nextInt();
            h[i] = in.nextInt();
        }

        if (n < 3) return n;

        // First tree
        int l = 1;
        int k = 0;
        int r = (x[0] + h[0] < x[1]) ? 1 : 0;

        int nl = 0, nk = 0, nr = 0;
        for (int i = 1; i < n - 1; ++i) {
            nl = nk = nr = 0;
            if (x[i] - h[i] > x[i-1]) nl = Math.max(Math.max(l, k), x[i] - h[i] > x[i-1] + h[i-1] ? r : 0) + 1;
            nk = Math.max(Math.max(l, k), r);
            if (x[i] + h[i] < x[i+1]) nr = Math.max(Math.max(l, k), r) + 1;
            l = nl; r = nr; k = nk;
        }
        return Math.max(Math.max(k, l), r) + 1;
    }
}
