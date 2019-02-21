import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve() ? "Yes" : "No");
    }

    private boolean solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int min = reduce(in.nextInt());
        for (int i = 0; i < n - 1; ++i) {
            if (min != reduce(in.nextInt())) return false;
        }
        return true;
    }

    private int reduce(int a) {
        while (a % 2 == 0) a /= 2;
        while (a % 3 == 0) a /= 3;
        return a;
    }
}
