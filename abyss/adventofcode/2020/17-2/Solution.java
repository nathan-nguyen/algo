import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int y = 0;
        Set<Long> set = new HashSet<>();
        while (in.hasNext()) {
            String s = in.next();
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '#') add(set, i, y, 0, 0);
            }
            ++y;
        }

        for (int i = 0; i < 6; ++i) set = cycle(set);
        System.out.println(set.size());
    }

    private void add(Set<Long> set, int x, int y, int z, int w) {
        set.add(getKey(x, y, z, w));
    }

    private long getKey(int x, int y, int z, int w) {
        return x * 1000_000_000L + y * 1000_000L + z * 1000L + w;
    }

    private Set<Long> cycle(Set<Long> set) {
        Set<Long> processed = new HashSet<>();
        Set<Long> next = new HashSet<>();
        for (long p: set) {
            List<Long> nbl = getNeighborList(p);
            processed.addAll(nbl);
        }
        for (long p: processed) {
            List<Long> nbl = getNeighborList(p);
            int activeCount = 0;
            for (long nb: nbl) {
                if (set.contains(nb)) ++activeCount;
            }
            if (set.contains(p) && (activeCount == 2 || activeCount == 3)) next.add(p);
            else if (!set.contains(p) && activeCount == 3) next.add(p);
        }
        return next;
    }

    private List<Long> getNeighborList(long p) {
        List<Long> nbl = new ArrayList();
        int w = (int) (p % 1000L);
        int z = (int) ((p % 1000_000L - w) / 1000L);
        int x = (int) (p / 1000_000_000L);
        int y = (int) ((p - x * 1000_000_000L - z * 1000L - w) / 1000_000L);
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    for (int u = -1; u <= 1; ++u) {
                        if (i == 0 && j == 0 && k == 0 && u == 0) continue;
                        long nb = getKey(x + i, y + j, z + k, w + u);
                        nbl.add(nb);
                    }
                }
            }
        }
        return nbl;
    }
}
