import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.length() > 0) sb.append(" " + s);
            else {
                if (sb.length() > 0) input.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) input.add(sb.toString());
        int sum = 0;
        for (String s: input) sum += countDistinctChar(s);
        System.out.println(sum);
    }

    private int countDistinctChar(String s) {
        int[] a = new int[512];
        for (int i = 0; i < s.length(); ++i) ++a[s.charAt(i)];

        int sum = 0;
        for (int i = 'a'; i <= 'z'; ++i) sum += a[i] > 0 ? 1 : 0;
        return sum;
    }
}
