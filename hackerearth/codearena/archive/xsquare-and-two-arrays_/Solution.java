import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int Q = in.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];
        long[] preA = new long[n + 1];
        long[] preB = new long[n + 1];

        for (int i = 0; i < n; ++i) A[i] = in.nextInt();
        for (int i = 0; i < n; ++i) B[i] = in.nextInt();

        for (int i = 1; i < n; i+=2) {
            A[i] = A[i] ^ B[i];
            B[i] = A[i] ^ B[i];
            A[i] = A[i] ^ B[i];
        }

        for (int i = 1; i <= n; ++i) {
            preA[i] = preA[i-1] + A[i-1];
            preB[i] = preB[i-1] + B[i-1];
        }

        while (Q -- > 0) {
            int type = in.nextInt();
            int L = in.nextInt();
            int R = in.nextInt();

            if (type % 2 == L % 2) System.out.println(preA[R] - preA[L - 1]);
            else System.out.println(preB[R] - preB[L - 1]);
        }
    }
}

