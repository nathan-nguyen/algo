class Solution {
	public int maxProfit(int[] p) {
		if (p.length == 0) return 0;

		int minPrice = p[0];
		int profit = 0;

		for (int i = 1; i < p.length; ++i){
			if (p[i] < minPrice) minPrice = p[i];
			else profit = Math.max(profit, p[i] - minPrice);
		}
		return profit;
	}
}
