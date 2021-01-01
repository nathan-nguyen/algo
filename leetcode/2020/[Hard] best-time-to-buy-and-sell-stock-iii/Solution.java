class Solution {
	public int maxProfit(int[] p) {
		if (p.length == 0) return 0;

		int n = p.length;

		int[] dpb = new int[n];
		int[] dpe = new int[n];

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i){
			if (p[i] < min) min = p[i];
			dpb[i] = p[i] - min;
		}

		int max = p[n-1];
		dpe[n-1] = 0;
		for (int i = n - 2; i >= 0; --i){
			if (p[i] > max) max = p[i];
			dpe[i] = Math.max(dpe[i + 1], max - p[i]);
		}

		int result = dpb[n-1];
		for (int i = 0; i < n - 1; ++i) result = Math.max(result, dpb[i] + dpe[i+1]);
		return result;
	}
}
