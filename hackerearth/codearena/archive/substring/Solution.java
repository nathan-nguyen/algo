import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            String s = in.next();
            int count = 0, result = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (isValid(s.charAt(i))) ++count;
                else {
                    result += count * (count + 1) / 2;
                    count = 0;
                }
            }
            result += count * (count + 1) / 2;
            System.out.println(result);
        }
    }

    private boolean isValid(char c) {
        return c == 'A' || c == 'a' || c == 'B' || c == 'b' || c == 'C' || c == 'c';
    }

}
