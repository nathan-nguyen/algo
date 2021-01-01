class Solution {
	public int candy(int[] a) {
        if (a.length == 0) return 0;
        int n = a.length;
		int total = a.length;
        
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; ++i) {
            if (a[i] > a[i-1]) left[i] = left[i-1] + 1;
        }

        for (int i = n - 2; i >= 0; --i) {
            if (a[i] > a[i+1]) right[i] = right[i+1] + 1;
        }

        for (int i = 0; i < n; ++i) total += Math.max(left[i], right[i]);
        return total;
	}
}
