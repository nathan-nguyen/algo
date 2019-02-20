import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve());
    }

    private String solve() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();

        if (n == 1) return "Impossible";

        int[] c = new int[26];
        for (int i = 0; i < s.length() / 2; ++i) ++c[s.charAt(i) - 'a'];
        int count = 0;
        for (int i = 0; i < 26; ++i) if (c[i] > 0) ++count;
        if (count == 1) return "Impossible";


        for (int i = 1; i <= n; ++i) {
            String ns = s.substring(i) + s.substring(0, i);
            if (verify(n, ns, s)) return "1";
        }

        return "2";
    }

    private boolean verify(int n, String ns, String s) {
        if (ns.equals(s)) return false;

        for (int i = 0; i < n / 2; ++i) {
            if (ns.charAt(i) != ns.charAt(n - 1- i)) return false;
        }
        return true;
    }
}