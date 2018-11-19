import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; ++i) set.add(in.next());

        System.out.println(combine(new String(), set).length()); 
    }

    private String combine(String s, Set<String> set) {
        if (set.size() == 0) return s;

        String result = new String();
        Set<String> next = new HashSet<>(set);

        for (String s1: set) {
            next.remove(s1);
            String s2 = combine(combine(s, s1), next);
            if (result.length() == 0 || s2.length() < result.length()) result = s2;
            next.add(s1);
        }
        return result;
    }

    private String combine(String s1, String s2) {
        int match = 0;
        for (int i = 1; i <= Math.min(s1.length(), s2.length()); ++i) {
            if (s1.substring(s1.length() - i).equals(s2.substring(0, i))) match = Math.max(i, match);
        }
        return s1 + s2.substring(match);
    }
}
