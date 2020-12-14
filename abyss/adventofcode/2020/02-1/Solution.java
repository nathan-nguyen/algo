import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int count = 0;
        while(in.hasNext()) {
            String s = in.nextLine();
            if (solve(s)) ++count;
        }
        System.out.println(count);
    }

    private boolean solve(String s) {
        String[] sp = s.split(" ");
        String[] range = sp[0].split("-");
        int[] c = countChar(sp[2]);
        int target = sp[1].charAt(0) - 'a';
        return c[target] >= Integer.parseInt(range[0]) && c[target] <= Integer.parseInt(range[1]);
    }

    private int[] countChar(String s) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); ++i) ++c[s.charAt(i) - 'a'];
        return c;
    }
}
