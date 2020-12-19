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
        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; ++i) tree.add(new ArrayList<>());

        boolean[] status = new boolean[n];
        for (int i = 0; i < n; ++i) status[i] = in.nextInt() == 1;

        for (int i = 0; i < n - 1; ++i) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        tree.get(0).add(-1);
        System.out.println(dfs(tree, -1, 0, 0, status, m));
    }

    private int dfs(List<List<Integer>> tree, int parent, int root, int current, boolean[] status, int m) {
        if (status[root] && current + 1 > m) return 0;
        if (tree.get(root).size() == 1) return 1;
        int total = 0;
        for (int child: tree.get(root)) {
            if (child == parent) continue;
            total += dfs(tree, root, child, status[root] ? current + 1 : 0, status, m);
        }
        return total;
    }
}
