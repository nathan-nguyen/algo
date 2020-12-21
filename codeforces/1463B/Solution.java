import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t -- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            long even = 0, odd = 0;
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
                if (i % 2 == 0) even += a[i];
                else odd += a[i];
            }
            int r = even >= odd ? 0 : 1 ;
            for (int i = 0; i < n; ++i) {
                if (i % 2 == r) System.out.print(a[i] + " ");
                else System.out.print("1 ");
            }
            System.out.println();
        }
    }
}
