import java.util.Scanner;

public class Solution {
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();
        int count = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (a[i] == 1) continue;
            if (a[i-1] == 1 && a[i + 1] == 1) {
                ++count;
                a[i + 1] = 0;
            }
        }
        System.out.println(count);
    }
}

