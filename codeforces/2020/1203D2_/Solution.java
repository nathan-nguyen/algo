import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();

        int es = 0, et = 0;
        while (es < s.length() && et < t.length()) {
            if (s.charAt(es) == t.charAt(et)) ++et;
            ++es;
        }

        int ss = s.length() - 1, st = t.length() - 1;
        while (ss >= 0 && st >= 0) {
            if (s.charAt(ss) == t.charAt(st)) --st;
            --ss;
        }

        System.out.println(Math.max(s.length() - es, ss +  1));
    }
}

