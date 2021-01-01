class Solution {
	public int maxProfit(int k, int[] p) {
		if (k < 1 || p.length < 2) return 0;

		int n = p.length;

		int total = 0;
		int count = 0;
		for (int i = 1; i < n; ++i){
			if (p[i] > p[i-1]) {
				total += (p[i] - p[i-1]);
				++count;
			}
		}
		if (k >= count) return total;

		int hold;
		int[][] notHold = new int[k+1][n];

		for (int i = 1; i <= k; ++i){
			hold = -p[0];
			for (int j = 1; j < n; ++j){
				notHold[i][j] = Math.max(hold + p[j], notHold[i][j-1]);
				hold = Math.max(hold, notHold[i-1][j-1] - p[j]);
			}
		}
		return notHold[k][n-1];
	}
}
