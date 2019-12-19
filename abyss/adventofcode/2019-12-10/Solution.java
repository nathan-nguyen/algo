import java.util.*;

public class Solution {
    private static final int n = 24;
    private static final int m = 24;
    private static final int lx = 20;
    private static final int ly = 21;

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() throws Exception {
        Scanner in = new Scanner(System.in);
        String[] map = new String[24];
        for (int i = 0; i < n; ++i) map[i] = in.next();
        solve(lx, ly, map);
    }

    private void solve(int x, int y, String[] map) throws Exception {
        List<Key> keyList = new ArrayList<>();
        Map<String, List<int[]>> keyMap = new HashMap<>();
        for (int i = -n; i <=n; ++i) {
            for (int j = -m; j <= m; ++j) {
                if (!hasAsteroid(x + i, y + j, map)) continue;
                Key key = new Key(i, j);
                String stringKey = key.toString();
                if (!keyMap.containsKey(stringKey)) {
                    keyList.add(key);
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    keyMap.put(stringKey, list);
                }
                else keyMap.get(stringKey).add(new int[]{i, j});
            }
        }
        
        Collections.sort(keyList, (u, v) -> compareKey(u, v));
        for (String key: keyMap.keySet()) {
            Collections.sort(keyMap.get(key), (u, v) -> Integer.compare(u[0] * u[0] + v[0] * v[0], u[1] * u[1] + v[1] * v[1]));
        }
        System.out.println(keyList);
        System.out.println(keyMap);
        System.out.println(keyList.size());
        
        int position = 0;
        for (int i = 0; i <= 200; ++i) {
            position = position % keyList.size();
            String stringKey = keyList.get(position).toString();
            System.out.println("Processing key " + stringKey + " at position " + position);
            if (keyMap.get(stringKey).size() == 0) {
                keyMap.remove(stringKey);
                keyList.remove(position);
                System.out.println("Removed key");
                --i;
            }
            else {
                System.out.println(stringKey);
                int[] asteroid = keyMap.get(stringKey).remove(0);
                System.out.println(asteroid[0] + " " + asteroid[1]);
                System.out.println("Answer: " + ((asteroid[0] + lx) * 100 + asteroid[1] + ly));
                ++position;
            }
        }
    }

    class Key {
        int region, x, y;
        public Key(int x, int y) throws Exception {
            if (x == 0 && y == 0) {
                this.x = 0;
                this.y = 0;
            }
            else if (x == 0) this.y = y > 0 ? 1 : -1;
            else if (y == 0) this.x = x > 0 ? 1 : -1;
            else {
                int gcd = gcd(Math.abs(x), Math.abs(y));
                this.x = x / gcd;
                this.y = y / gcd;
            }
            this.region = getRegion(x, y);
        }

        private int getRegion(int x, int y) throws Exception{
            if (x == 0 && y == 0) return 0;
            if (x == 0 && y < 0) return 1;
            if (x > 0 && y < 0) return 2;
            if (x > 0 && y == 0) return 3;
            if (x > 0 && y > 0) return 4;
            if (x == 0 && y > 0) return 5;
            if (x < 0 && y > 0) return 6;
            if (x < 0 && y == 0) return 7;
            if (x < 0 && y < 0) return 8;
            throw new Exception("Invalid case x = " + x + " y = " + y);
        }

        public String toString() {
            if (x == 0 && y == 0) return "_0_0";
            if (x == 0) return "_0" + (y > 0 ? "+1" : "-1");
            if (y == 0) return (x > 0 ? "+1" : "-1") + "_0";
            return (x > 0 ? "+" : "") + x + (y > 0 ? "+" : "") + y;
        }
    }

    private int gcd(int x, int y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }

    private boolean hasAsteroid(int i, int j, String[] map) {
        if (i >= 0 && i < n && j >= 0 && j < n) return map[j].charAt(i) == '#';
        return false;
    }

    private int compareKey(Key k1, Key k2) {
        if (k1.region != k2.region) return Integer.compare(k1.region, k2.region);
        int compareResult = Integer.compare(Math.abs(k1.x * k2.y), Math.abs(k1.y * k2.x));
        if (k1.region == 2 || k1.region == 6) return compareResult;
        return -compareResult;  // k1.region == 4 || k1.region == 8
    }
}
