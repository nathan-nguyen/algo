import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        Queue<Long> queue = new LinkedList<>();
        Map<Long, Integer> map = new HashMap<>();
        while (in.hasNext()) {
            long a = in.nextLong();
            if (queue.size() >= 25) {
                if (!check(queue, map, a)) {
                    System.out.println(a);
                    return;
                }
                long x = queue.poll();
                map.put(x, map.get(x) - 1);
            }
            queue.offer(a);
            map.put(a, map.getOrDefault(a, 0) + 1);
        } 
    }

    private boolean check(Queue<Long> queue, Map<Long, Integer> map, long a) {
        for (long e: queue) {
            if (map.getOrDefault(a - e, 0) > 0) return true;
        }
        return false;
    }
}
