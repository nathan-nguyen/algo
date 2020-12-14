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
        while (in.hasNextLine()) {
            String s = in.nextLine();
            input.add(s);
        }
        int t1 = solve(input, 1, 1);
        int t2 = solve(input, 1, 3);
        int t3 = solve(input, 1, 5);
        int t4 = solve(input, 1, 7);
        int t5 = solve(input, 2, 1);
        System.out.println((long) t1 * t2 * t3 * t4 * t5);
    }

    private int solve(List<String> input, int u, int v) {
        int n = input.size();
        int m = input.get(0).length();

        int count = 0;
        for (int i = 0, j = 0; i < n; i+=u, j+=v) {
            if (input.get(i).charAt(j % m) != '.') ++count;
        }
        return count;
    }
}
