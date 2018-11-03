import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long[] a = new long[n];
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            set.add(a[i]);
        }
        List<Long> list = new ArrayList<>(set);
        Collections.sort(list);

        long[] dp = new long[list.size()];
        dp[0] = Math.abs(a[0] - list.get(0));

        for (int i = 1; i < list.size(); ++i) dp[i] = Math.min(dp[i-1], Math.abs(a[0] - list.get(i)));

        for (int i = 1; i < n; ++i) {
            long[] row = new long[list.size()];
            row[0] = dp[0] + Math.abs(a[i] - list.get(0));
            for (int j = 1; j < list.size(); ++j) {
                row[j] = Math.min(row[j-1], dp[j] + Math.abs(a[i] - list.get(j)));
            }
            dp = row;
        }
        System.out.println(dp[list.size() - 1]);
    }

}
