import java.util.*;

class Solution {
    public int minIncrementForUnique(int[] a) {
        if (a.length == 0) return 0;

        int n = a.length;
        Arrays.sort(a);
        int count = 0;
        for (int i = 1; i < n; ++i) {
            if (a[i] <= a[i-1]) {
                count += (a[i-1] + 1 - a[i]);
                a[i] = a[i-1] + 1;
            }
        }
        return count;
    }
}

