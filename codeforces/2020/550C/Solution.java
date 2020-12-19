import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        String ans = solution.solve(n, s);
        System.out.println(ans.equals("-1") ? "NO" : "YES\n" + ans);
    }

    private String solve(int n, String s) {
        boolean[] one = new boolean[10];
        boolean[] two = new boolean[100];

        for (int i = n - 1; i >= 0; --i) {
            int d = s.charAt(i) - '0';
            if (d % 8 == 0) return String.valueOf(d);

            for (int j = 0; j < 100; ++j) {
                if (two[j] && (d * 100 + j) % 8 == 0) return s.substring(0, i + 1) + j;
            }

            for (int j = 0; j < 10; ++j) {
                if (!one[j]) continue;
                if ((d * 10 + j) % 8 == 0) return String.valueOf(d * 10 + j);
                two[d * 10 + j] = true;
            }
            one[d] = true;
        }
        return "-1";
    }
}
