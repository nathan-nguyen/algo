import java.util.*;

public class Solution {
    private static final int n = 24;
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        String[] map = new String[24];
        for (int i = 0; i < n; ++i) map[i] = in.next();
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) max = Math.max(max, solve(i, j, map));
        }
        System.out.println(max);
    }

    private int solve(int x, int y, String[] map) {
        Set<String> keyList = new HashSet<>();
        for (int i = -n; i <=n; ++i) {
            for (int j = -n; j <= n; ++j) {
                if (hasAsteroid(x + i, y + j, map)) {
                    String key = getKey(i, j);
                    if (!keyList.contains(key)) keyList.add(key);
                }
            }
        }
        return keyList.size();
    }

    private String getKey(int x, int y) {
        if (x == 0 && y == 0) return "_0_0";
        if (x == 0) return "_0" + (y > 0 ? "+1" : "-1");
        if (y == 0) return (x > 0 ? "+1" : "-1") + "_0";
        int gcd = gcd(x, y);
        return (x > 0 ? "+" : "") + (x / gcd) + (y > 0 ? "+" : "") + (y / gcd);
    }

    private int gcd(int x, int y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }

    private boolean hasAsteroid(int i, int j, String[] map) {
        if (i >= 0 && i < n && j >= 0 && j < n) return map[i].charAt(j) == '#';
        return false;
    }
}
