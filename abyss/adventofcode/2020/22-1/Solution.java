import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        Queue<Integer> one = new LinkedList<>();
        Queue<Integer> two = new LinkedList<>();

        Queue<Integer> next = one;
        while (in.hasNext()) {
            String s = in.nextLine();
            if (s.length() == 0) {
                next = two;
                continue;
            }
            else if (s.contains("Player")) continue;
            next.offer(Integer.parseInt(s));
        }
        System.out.println(one + " " + two);

        while (!one.isEmpty() && !two.isEmpty()) {
            int n1 = one.poll();
            int n2 = two.poll();
            if (n1 > n2) {
                one.offer(n1);
                one.offer(n2);
            } else {
                two.offer(n2);
                two.offer(n1);
            }
        }

        System.out.println(one + " " + two);
        next = one.isEmpty() ? two : one;
        long result = 0L;
        while (!next.isEmpty()) result += next.size() * next.poll();

        System.out.println(result);
    }
}
