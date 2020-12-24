import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private static final int[] CENTER = new int[]{0, 0};

    private void solve() {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        while (in.hasNext()) {
            String s = in.next();
            int[] a = flip(s, CENTER);
            int p = a[0] * 1000 + a[1];
            if (set.contains(p)) set.remove(p);
            else set.add(p);
        }
        System.out.println(set.size());
    }

    private int[] move(char c, int x, int y, int step) {
        switch (c) {
            case 'n': y += step; break;
            case 'e': x += step; break;
            case 's': y -= step; break;
            case 'w': x -= step; break;
        }
        return new int[]{x, y};
    }

    private int[] flip(String s, int[] p) {
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'w' || c == 'e') p = move(c, p[0], p[1], 2);
            else {
                p = move(c, p[0], p[1], 1);
                ++i;
                c = s.charAt(i);
                p = move(c, p[0], p[1], 1);
            }
        }
        return p;
    }
}
