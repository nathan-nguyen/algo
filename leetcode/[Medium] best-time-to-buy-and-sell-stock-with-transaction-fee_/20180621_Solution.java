class Solution {
	public int maxProfit(int[] p, int fee) {
		if (p.length == 0) return 0;

		int notBuy = 0;
		int hold = -p[0];

		for (int i = 1; i < p.length; ++i){
			notBuy = Math.max(notBuy, hold + p[i] - fee);
			hold = Math.max(hold, notBuy - p[i]);
		}
		return notBuy;
	}
}
