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

		for (int i = 0; i < n; ++i){
			min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int j = i + 1; j < n; ++j){
				if (p[j] < min) min = p[j];
				max = Math.max(max, p[j] - min);
			}
			dpe[i] = max;
		}

		int result = dpb[n-1];
		for (int i = 0; i < n; ++i) result = Math.max(result, dpb[i] + dpe[i]);
		return result;
	}
}
