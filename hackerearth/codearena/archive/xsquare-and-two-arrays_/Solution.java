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
        long[] preAe = new long[n];
        long[] preAo = new long[n];
        int[] B = new int[n];
        long[] preBe = new long[n];
        long[] preBo = new long[n];
        for (int i = 0; i < n; ++i) {
            A[i] = in.nextInt();
            if (i % 2 == 0) preAe[i] += (i > 1 ? preAe[i - 2] : 0) + A[i];
            else preAo[i] += (i > 1 ? preAo[i - 2] : 0) + A[i];
        }

        for (int i = 0; i < n; ++i) {
            B[i] = in.nextInt();
            if (i % 2 == 0) preBe[i] += (i > 1 ? preBe[i - 2] : 0) + B[i];
            else preBo[i] += (i > 1 ? preBo[i - 2] : 0) + B[i];
        }

        while (Q -- > 0) {
            int type = in.nextInt();
            int L = in.nextInt() - 1;
            int R = in.nextInt() - 1;
            int evenL = L % 2 == 0 ? (L - 2) : (L - 1);
            int oddL = L % 2 == 0 ? (L - 1) : (L - 2);
            int evenR = R % 2 == 0 ? R : (R - 1);
            int oddR = R % 2 == 0 ? (R - 1) : R;

            if (type == 1) {
                if (L % 2 == 0) System.out.println(preAe[evenR] - (evenL < 0 ? 0 : preAe[evenL]) + preBo[oddR] - (oddL < 0 ? 0 : preBo[oddL]));
                else System.out.println(preAo[oddR] - (oddL < 0 ? 0 : preAo[oddL]) + preBe[evenR] - (evenL < 0 ? 0 : preBe[evenL]));
            } else {
                if (L % 2 == 0) System.out.println(preBe[evenR] - (evenL < 0 ? 0 : preBe[evenL]) + preAo[oddR] - (oddL < 0 ? 0 : preAo[oddL]));
                else System.out.println(preBo[oddR] - (oddL < 0 ? 0 : preBo[oddL]) + preAe[evenR] - (evenL < 0 ? 0 : preAe[evenL]));
            }
        }
    }
}

