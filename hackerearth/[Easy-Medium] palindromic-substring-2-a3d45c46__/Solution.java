import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int t = in.nextInt();
        while (t -- > 0) {
            int k = in.nextInt();
            System.out.println(search(s, k));
        }
    }

    private int search(String s, int k) {
    }

    private boolean search(String s, int k, int x) {
        int[] count = new int[n];
        for (int i = 0; i < x; ++i) ++count[s.charAt(i) - 'a'];
        int odd = 0, total = 0;
        for (int i = 0; i < n; ++i) {
            if (count[i] % 2 == 1) ++odd;
        }
        // if (odd > 0) --> x - odd + 1;
        // else --> x

        if (total >= k) return true;
        for (int i = x; i < s.length(); ++i) {
            --count[charAt(i-x) - 'a'];
            if (count[s.charAt(i-x) - 'a'] % 2 == 0) --odd;
            else ++odd;

            ++count[s.charAt(i) - 'a'];
            if (count[s.charAt(i) - 'a'] % 2 == 1) ++odd;
            else --odd;

            if (odd > 0 && x - odd + 1 >= k) return true;
            else if (odd == 0 && x >= k) return true;
        }
        return false;
    }

}
