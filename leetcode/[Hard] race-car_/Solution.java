class Solution {
	public int racecar(int target) {
		if (target == 0) return 0;

		int[] dp = new int[target + 1];
		return findSolution(dp, target); 
	}

	private int findSolution(int[] dp, int n){
		if (dp[n] > 0) return dp[n];

		int k = (int) (Math.log(n) / Math.log(2)) + 1;

		if (n == (1 << k) - 1) dp[n] = k;
		else {
			// Pass , turn back and go
			dp[n] = k + 1 + findSolution(dp, (1 << k) - 1 - n);
			
			// Come close, turn back twice and forward
			for (int m = 0; m < k - 1; ++m)
				dp[n] = Math.min(dp[n], (k - 1) + 1 + m + 1 + findSolution(dp, n - ((1 << (k - 1)) - 1 - ((1 << m) - 1))));
			
		}
		return dp[n];
	}
}
