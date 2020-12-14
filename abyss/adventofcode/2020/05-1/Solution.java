import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int max = 0;
        while(in.hasNext()) {
            String s = in.next();
            max = Math.max(max, getSeat(s));
        }
        System.out.println(max);
    }

    private int getSeat(String s) {
        int row = decode(s.substring(0, 8), 0, 127);
        int col = decode(s.substring(7), 0, 7);
        System.out.println(row + " " + col);
        return row * 8 + col;  
    }

    private int decode(String code, int s, int e) {
        System.out.println(code + " " + s + " " + e);
        if (code.length() == 1) {
            if (code.charAt(0) == 'F' || code.charAt(0) == 'L') return s;
            return e;
        }
        if (code.length() == 0) return s;
        int mid = (s + e) / 2;
        if (code.charAt(0) == 'F' || code.charAt(0) == 'L') return decode(code.substring(1), s, mid);
        return decode(code.substring(1), mid + 1, e);
    }
}
