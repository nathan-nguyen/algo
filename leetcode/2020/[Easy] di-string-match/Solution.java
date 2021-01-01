class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] a = new int[n + 1];
        int min = -1, max = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i-1) == 'I') a[i] = max++;
            else a[i] = min--;
        }
        ++min;
        for (int i = 0; i <= n ; ++i) a[i] -= min;
        return a;
    }
}

