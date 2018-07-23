class Solution {
	public int maxProfit(int[] p) {
		if (p.length == 0) return 0;

		int max = 0;
		int min = p[0];

		for (int i = 1; i < p.length; ++i) {
			min = Math.min(min, p[i]);
			max = Math.max(max, p[i] - min);
		}
		return max;
	}
}
