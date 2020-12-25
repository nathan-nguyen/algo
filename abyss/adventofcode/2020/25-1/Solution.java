import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private static final int N = 20201227;

    private void solve() {
        Scanner in = new Scanner(System.in);
        long n1 = in.nextLong();
        long n2 = in.nextLong();
        int l1 = getLoop(n1);
        int l2 = getLoop(n2);
        System.out.println(l1 + " " + l2);
        System.out.println(transform(n1, l2));
        System.out.println(transform(n2, l1));
    }

    private int getLoop(long n1) {
        int n = 1;
        int loop = 0;
        while (n != n1) {
            ++loop;
            n = (n * 7) % N;
        }
        return loop;
    }

    private long transform(long s, int loop) {
        long n = 1;
        for (int i = 0; i < loop; ++i) n = (n * s) % N;
        return n;
    }

}
