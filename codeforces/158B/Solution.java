import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve());
    }

    private int solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] count = new int[4];
        for (int i = 0; i < n; ++i) ++count[in.nextInt() - 1];

        int result = count[3] + count[2] + count[1] /  2;
        count[0] -= Math.min(count[0], count[2]);
        count[1] = count[1] % 2;
        if (count[1] == 0) result += count[0] % 4 == 0 ? count[0] / 4 : count[0] / 4 + 1;
        else result += (count[0] + 2) % 4 == 0 ? (count[0] + 2) / 4 : (count[0] + 2) / 4 + 1;
        return result;
    }
}
