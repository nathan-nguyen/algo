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
        List<String> ppl = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.length() > 0) sb.append(" " + s);
            else if (sb.length() > 0) {
                ppl.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) ppl.add(sb.toString());

        int count = 0;
        for (String s: ppl) {
            if (isValid(s)) ++count;
        }
        System.out.println(count);
    }

    private static String[] REQUIRED_FIELDS = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

    private boolean isValid(String s) {
        for (String rf: REQUIRED_FIELDS) {
            if (!s.contains(rf + ":")) return false;
        }
        return true;
    }
}
