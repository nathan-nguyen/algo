import  java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String[] sp = s.split(",");
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        int cur = 0;
        for (int i = 1; i <= 2020; ++i) {
            if (i <= sp.length) cur = Integer.parseInt(sp[i - 1]);
            else if (map.get(cur).size() == 1) cur = 0;
            else {
                Queue<Integer> queue = map.get(cur);
                int t1 = queue.poll();
                int t2 = queue.peek();
                cur = t2 - t1;
            }
            add(map, cur, i);
        }
        System.out.println(cur);
    }

    private void add(Map<Integer, Queue<Integer>> map, int cur, int pos) {
        if (!map.containsKey(cur)) map.put(cur, new LinkedList<>());
        map.get(cur).offer(pos);
    }
}
