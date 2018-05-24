class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;

		int profit = 0;

		int max = prices[prices.length - 1];
		for (int i = prices.length - 1; i >= 1; --i){
			if (prices[i] < prices[i - 1]) {
				profit += max - prices[i];
				max = prices[i - 1];
			}
		}
		profit += max - prices[0];
		return profit;
	}
}
