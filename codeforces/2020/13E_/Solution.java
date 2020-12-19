import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private int n, k;
    private int[] a, next, count;

    private void solve() {
        Scanner in = new Scanner(System.in);
        this.n = in.nextInt();
        this.k = (int) Math.sqrt(n);
        int m = in.nextInt();

        this.a = new int[n];
        this.next = new int[n];
        this.count = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();

        int range = n % k == 0 ? n / k : n / k + 1;
        for (int i = 0; i < range; ++i) {
            boolean[] v = new boolean[n];
            int start = k * i;
            int end = Math.min(n, start + k);
            for (int j = start; j < end; ++j) update(j, end, v);
        }

        for (int i = 0; i < m; ++i) {
            int type = in.nextInt();
            if (type == 0) update(in.nextInt() - 1, in.nextInt());
            else {
                int[] result = get(in.nextInt() - 1);
                System.out.println((result[0] + 1)+ " " + result[1]);
            }
        }
        
    }

    private int[] get(int i) {
        int result = 0;
        while (next[i] < n) {
            result += count[i];
            i = next[i];
        }
        result += count[i];
        return new int[]{i, result};
    }

    private void update(int index, int value) {
        a[index] = value;
        int start = (index / k) * k;
        int end = Math.min(start + k, n);
        boolean[] v = new boolean[n];

        for (int i = start; i < end; ++i) update(i, end, v);
    }

    private int[] update(int i, int end, boolean[] v) {
        if (i >= end) return new int[]{i, 0};
        if (v[i]) return new int[]{next[i], count[i]};

        v[i] = true;
        int[] result = update(i + a[i], end, v);
        next[i] = result[0];
        count[i] = result[1] + 1;

        return new int[]{next[i], count[i]};
    }
}
