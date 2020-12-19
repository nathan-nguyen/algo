import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
    
    private void solve() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) a[i] = in.nextInt();
            System.out.println(solve(n, a) ? "YES" : "NO");
        }
    }

    private boolean solve(int n , int[] a) {
        Arrays.sort(a);
        for (int i = 1; i < n; ++i) {
            if (a[i] - a[i-1] > 1) return false;
        }
        return true;
    }
}
