import java.util.*;

class Solution {
    private List<Integer> numberOfItems(String s, List<Integer> start, List<Integer> end) {
        int n = s.length();
        int[] count = new int[n + 1]; // count[i]: first i characters
        int[] left = new int[n];
        int[] right = new int[n];

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; ++i) count[i] = count[i-1] + (s.charAt(i-1) == '*' ? 1 : 0);

        left[0] = s.charAt(0) == '*' ? 1 : 0;
        for (int i = 1; i < n; ++i) left[i] = s.charAt(i) == '*' ? left[i-1] + 1 : 0;

        right[n-1] = s.charAt(n - 1) == '*' ? 1 : 0;
        for (int i = n - 2; i >= 0; --i) right[i] = s.charAt(i) == '*' ? right[i+1] + 1 : 0;
        
        for (int i = 0; i < start.size(); ++i) {
            int l = start.get(i);
            int r = end.get(i);
            // System.out.println(l + " " + r + " " + right[l-1] + " " + left[r-1]);
            result.add(count[r] - count[l-1] - right[l-1] - left[r-1]);
        }
        return result;
    }
}
