import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[][] edge = new int[n-1][3];
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < 3; ++j) edge[i][j] = in.nextInt();
        }

        Arrays.sort(edge, (u, v) -> Integer.compare(v[2], u[2]));

        boolean[] machine = new boolean[n];
        for (int i = 0; i < k; ++i) machine[in.nextInt()] = true;

        int[] pr = new int[n];
        int[] sz = new int[n];
        for (int i = 0; i < n; ++i) {
            pr[i] = i;
            sz[i] = 1;
        }

        long result = 0;
        for (int[] e: edge) {
            if (!connect(e[0], e[1], pr, sz, machine)) result += e[2];
        }
        System.out.println(result);
    }

    private boolean connect(int a, int b, int[] pr, int[] sz, boolean[] machine) {
        while (a != pr[a]) a = pr[a];
        while (b != pr[b]) b = pr[b];

        if (a == b || (machine[a] && machine[b])) return false;
        if (sz[a] <= sz[b]) {
            pr[a] = b;
            sz[b] += sz[a];
            machine[b] = machine[a] || machine[b];
        } else {
            pr[b] = a;
            sz[a] += sz[b];
            machine[a] = machine[a] || machine[b];
        }
        return true;
    }
}
