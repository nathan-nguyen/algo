import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve());
    }

    private int solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] cost = new int[3][n];

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) g.add(new ArrayList<>());

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < n; ++j) cost[i][j] = in.nextInt();
        }

        int[] degree = new int[n];

        for (int i = 0; i < n - 1; ++i) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            g.get(a).add(b);
            g.get(b).add(a);
            ++degree[a];
            ++degree[b];
        }

        for (int i = 0; i < n; ++i) if (degree[i] > 2) return -1;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < n; ++j) {
                // Start with vertex with degree = 1
                if (degree[j] == 1) {
                    break;
                }
            }
        }
        return 0;
    }

}
