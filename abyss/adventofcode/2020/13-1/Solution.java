import java.util.Scanner;

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
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (String e: sp) {
            if (e.equals("x")) continue;
            int n = Integer.parseInt(e);
            int next = (n - (t % n)) % n;
            if (next < min) {
                System.out.println(n + " " + next);
                min = next;
                result = min * n;
            }
        }
        System.out.println(result);
    }
}
