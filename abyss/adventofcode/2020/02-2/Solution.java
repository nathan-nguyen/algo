import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int count = 0;
        while(in.hasNext()) {
            String s = in.nextLine();
            if (solve(s)) ++count;
        }
        System.out.println(count);
    }

    private boolean solve(String s) {
        String[] sp = s.split(" ");
        String[] range = sp[0].split("-");
        char target = sp[1].charAt(0);
        int left = Integer.parseInt(range[0]) - 1;
        int right = Integer.parseInt(range[1]) - 1;
        return sp[2].charAt(left) != sp[2].charAt(right) && (sp[2].charAt(left) == target || sp[2].charAt(right) == target);
    }
}
