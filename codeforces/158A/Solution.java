import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve());
    }

    private int solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();

        if (k > n) k = n;

        Arrays.sort(a);

        for (int i = 0; i < n; ++i) {
            if (a[n - 1 - i] <= 0 || a[n - 1 - i] < a[n - k]) return i;
        }
        return n;
    }
}
