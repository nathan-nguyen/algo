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
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        if (min * 2 < max) max = min * 2;
        System.out.println((min + max) / 3);
    }
}

