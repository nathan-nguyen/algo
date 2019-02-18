import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve());
    }

    private String solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int k1 = in.nextInt();
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < k1; ++i) q1.offer(in.nextInt());

        int k2 = in.nextInt();
        Queue<Integer> q2 = new LinkedList<>(); 
        for (int i = 0; i < k2; ++i) q2.offer(in.nextInt());

        Set<String> state = new HashSet<>();
        int count = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            String currentState = q1.toString() + q2.toString();
            if (state.contains(currentState)) return "-1";
            else state.add(currentState);

            int v1 = q1.poll();
            int v2 = q2.poll();
            if (v1 > v2) {
                q1.offer(v2);
                q1.offer(v1);
            } else {
                q2.offer(v1);
                q2.offer(v2);
            }
            ++count;
        }

        if (q1.isEmpty()) return count + " 2";
        if (q2.isEmpty()) return count + " 1";
        return "-1";
    }
}
