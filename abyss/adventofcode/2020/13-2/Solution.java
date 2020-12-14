import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        System.out.println(s);
        String[] sp = s.split(",");

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < sp.length; ++i) {
            if (sp[i].equals("x")) continue;
            int n = Integer.parseInt(sp[i]);
            queue.offer(new int[]{n, (n - i % n) % n});
        }

        long time = 0, inc = 1;
        while (queue.size() > 0) {
            System.out.println(time + " " + inc);
            int[] e = queue.peek();
            if (check(time, queue)) break;
            if (time % e[0] == e[1]) {
                inc *= e[0];
                queue.poll();
            }
            time += inc;
        }
        System.out.println(time);
    }

    private boolean check(long n, Queue<int[]> queue) {
        for (int[] e: queue) {
            if (n % e[0] != e[1]) return false;
        }
        return true;
    }
}
