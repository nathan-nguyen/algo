import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();
        input.add(0);
        while (in.hasNext()) {
            int a = in.nextInt();
            input.add(a);
        }
        Collections.sort(input);
        long[] dp = new long[input.size()];
        dp[0] = 1;
        for (int i = 1; i < input.size(); ++i) {
            int  a = input.get(i);
            for (int j = 1; j <= 3; ++j) {
                if (i >= j) {
                    int number = input.get(i - j);
                    if (a - number <= 3) dp[i] += dp[i-j];
                }
            }
        }
        System.out.println(dp[input.size() - 1]);
    }
}
