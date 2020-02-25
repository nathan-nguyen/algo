import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < args.length; ++i) {
            if (args[i].length() != args[i-1].length()) {
                System.out.println("Invalid input " + args[i-1] + " " + args[i]);
                return;
            }
        }
        for (String s: args) list.add(s);

        Solution solution = new Solution();
        solution.solve(list);
    }

    private void solve(List<String> list) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; ++i) {
            String s = in.next();
            int m = in.nextInt();
            List<String> next = new ArrayList<>();
            for (String v: list) {
                if (findMatch(s, v) == m) next.add(v);
            }
            list = next;
            System.out.println(list);
        }
    }

    private int findMatch(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) == s2.charAt(i)) ++count;
        }
        return count;
    }
}
