class Solution {
	public int maxProfit(int[] p) {
		if (p.length == 0) return 0;

		// 0 - Not buy ; 1 - Hold
		int notBuy = 0;
		int hold = -p[0];

		for (int i = 1; i < p.length; ++i){
			notBuy = Math.max(notBuy, hold + p[i]);
			hold = notBuy - p[i];
		}

		return notBuy;
	}
}
