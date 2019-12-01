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
        if (!search(s, k, s.length())) return -1;
        int left = k, right = s.length() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (search(s, k, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean search(String s, int k, int x) {
        int[] count = new int[26];
        for (int i = 0; i < x; ++i) ++count[s.charAt(i) - 'a'];
        int odd = 0;
        for (int i = 0; i < 26; ++i) {
            if (count[i] % 2 == 1) ++odd;
        }

        if (verify(x, odd, k)) return true;

        for (int i = x; i < s.length(); ++i) {
            --count[s.charAt(i-x) - 'a'];
            if (count[s.charAt(i-x) - 'a'] % 2 == 0) --odd;
            else ++odd;

            ++count[s.charAt(i) - 'a'];
            if (count[s.charAt(i) - 'a'] % 2 == 1) ++odd;
            else --odd;

            if (verify(x, odd, k)) return true;
        }
        return false;
    }

    private boolean verify(int total, int odd, int k) {
        return (odd == 0 && total >= k) || (odd > 0 && total - odd + 1 >= k);
    }
}
