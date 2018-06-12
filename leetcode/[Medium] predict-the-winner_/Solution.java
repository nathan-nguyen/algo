class Solution {
	private int[][] dp;
	public boolean PredictTheWinner(int[] nums) {
		if (nums.length == 0) return true;

		int n = nums.length;
		dp = new int[n][n];
		int first = predict(0, n - 1, nums);
		int second = Math.min(predict(1, n - 1, nums), predict(0, n - 2, nums));
		return first >= second;
	}

	private int predict(int start, int end, int[] nums){
		if (start > end) return 0;

		if (dp[start][end] > 0) return dp[start][end];

		if (start == end) dp[start][end] = nums[start];
		else if (end == start + 1) dp[start][end] = Math.max(nums[start], nums[end]);
		else dp[start][end] = Math.max(nums[start] + Math.min(predict(start + 2, end, nums), predict(start + 1, end - 1, nums)),
					Math.min(predict(start + 1, end - 1, nums), predict(start, end - 2, nums)) + nums[end]);

		return dp[start][end];
	}
}
