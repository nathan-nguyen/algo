class Solution {
    public int repeatedNTimes(int[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i] == a[i+1]) return a[i];
        }
        if (a[1] == a[3]) return a[1];
        return a[0];
    }
}

