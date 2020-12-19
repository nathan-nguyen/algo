import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve());
    }

    private String solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = Integer.MIN_VALUE;

        Map<String, Integer> map = new HashMap<>();
        String[] nameOrder = new String[n];
        int[] scoreOrder = new int[n];
        for (int i = 0; i < n; ++i) {
            nameOrder[i] = in.next();
            scoreOrder[i] = in.nextInt();
            int currentScore = map.getOrDefault(nameOrder[i], 0) + scoreOrder[i];
            map.put(nameOrder[i], currentScore);
        }

        for (String s: map.keySet()) max = Math.max(max, map.get(s));
        Set<String> set = new HashSet<>();
        for (String s: map.keySet()) {
            if (map.get(s) == max) set.add(s);
        }

        if (set.size() == 1) return set.iterator().next();

        map.clear();
        for (int i = 0; i < n; ++i) {
            if (!set.contains(nameOrder[i])) continue;
            int score = map.getOrDefault(nameOrder[i], 0) + scoreOrder[i];
            if (score >= max) return nameOrder[i];
            map.put(nameOrder[i], score);
        }
        return "---";
    }
}
