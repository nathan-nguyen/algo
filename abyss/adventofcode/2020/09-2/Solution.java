import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        List<Long> input = new ArrayList<>();
        List<Long> ps = new ArrayList<>();
        ps.add(0L);
        while (in.hasNext()) {
            long a = in.nextLong();
            input.add(a);
            ps.add(ps.get(ps.size() - 1) + a);
        }
        for (int i = 0; i < ps.size(); ++i) {
            for (int j = i + 1; j < ps.size(); ++j) {
                if (ps.get(j) - ps.get(i) == 1721308972) {
                    long min = Long.MAX_VALUE;
                    long max = Long.MIN_VALUE;
                    for (int x = i; x < j; ++x) {
                        min = Math.min(min, input.get(x));
                        max = Math.max(max, input.get(x));
                    }
                    System.out.println(min + " " + max + " " + (min + max));
                    return;
                }
            }
        }
    }

    private boolean check(Queue<Long> queue, Map<Long, Integer> map, long a) {
        for (long e: queue) {
            if (map.getOrDefault(a - e, 0) > 0) return true;
        }
        return false;
    }
}
