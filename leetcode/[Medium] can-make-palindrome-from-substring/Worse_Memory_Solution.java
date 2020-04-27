import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        int n = s.length();
        int[][] count = new int[n + 1][26];

        for (int i = 1; i <= n; ++i) {
            ++count[i][s.charAt(i - 1) - 'a'];
            for (int j = 0; j < 26; ++j) count[i][j] += count[i-1][j];
        }

        for (int[] q: queries) {
            int diff = 2 * q[2] + 1;
            for (int i = 0; i < 26 && diff >= 0; ++i) {
                int value = count[q[1] + 1][i] - count[q[0]][i];
                diff -= value % 2;
            }
            result.add(diff >= 0);
        }

        return result;
    }
}
