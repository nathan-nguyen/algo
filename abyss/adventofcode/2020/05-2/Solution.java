import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve());
    }

    private int solve() {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while(in.hasNext()) {
            String s = in.next();
            int st = getSeat(s);
            min = Math.min(min, st);
            max = Math.max(max, st);
            set.add(st);
        }

        for (int i = min; i < max; ++i) {
            if (!set.contains(i)) return i;
        }
        return -1;
    }

    private int getSeat(String s) {
        int row = decode(s.substring(0, 8), 0, 127);
        int col = decode(s.substring(7), 0, 7);
//        System.out.println(row + " " + col + " " + (row * 8 + col));
        return row * 8 + col;  
    }

    private int decode(String code, int s, int e) {
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
