import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve());
    }

    private String solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        if (m < n - 1 || m > 2 * n + 2) return "-1";

        StringBuilder sb = new StringBuilder();
        if (m == n - 1) {
            for (int i = 0; i < m; ++i) sb.append("01");
            sb.append("0");
        }
        else if (m == 2 * n + 2) {
            for (int i = 0; i < n; ++i) sb.append("110");
            sb.append("11");
        }
        else {
            while (n > 0 && m != n) {
                sb.append("110");
                m -= 2;
                n -= 1;
            }
            for (int i = 0; i < n; ++i) sb.append("10");
            m -= n;
            if (m > 0) sb.append(1);
        }
        return sb.toString();
    }
}

