import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int s = in.nextInt();
        if (9 * k < s || (k > 1 && s == 0)) {
            System.out.println("-1 -1");
            return;
        }
        if (k == 1 && s == 0) {
            System.out.println("0 0");
            return;
        }

        System.out.println(getMin(k, s) + " " + getMax(k, s));
    }

    private String getMax(int k, int s) {
        StringBuilder max = new StringBuilder();
        for (int i = 0; i < s / 9; ++i) max.append(9);
        if (s % 9 != 0) max.append(s % 9);
        for (int i = s / 9 + (s % 9 == 0 ? 0 : 1); i < k; ++i) max.append(0);
        return max.toString();
    }

    private String getMin(int k, int s) {
        StringBuilder min = new StringBuilder();
        int c = 9 * (k - 1) < s ? 0 : 1;
        int x = (s - c) % 9;
        int a = (s - c) / 9;
        int b = k - (c == 1 ? 1 : 0) - a - (x == 0 ? 0 : 1);
        if (c == 1) min.append(1);
        for (int i = 0; i < b; ++i) min.append(0);
        if (x != 0) min.append(x);
        for (int i = 0; i < a; ++i) min.append(9);
        return min.toString();
    }
}
