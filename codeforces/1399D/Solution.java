import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            solve(n, s);
        }
    }

    private void solve(int n, String s) {
        int count = 0;
        List<Stack<Integer>> sl = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sl.add(new Stack<>());
        sl.add(new Stack<>());

        for (int i = 0; i < n; ++i) {
            int a = s.charAt(i) - '0';
            if (sl.get(1-a).isEmpty()) {
                ++count;
                sl.get(a).push(count);
            }
            else sl.get(a).push(sl.get(1-a).pop());
            sb.append(sl.get(a).peek() + " ");
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
