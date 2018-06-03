class Solution {
	public int jump(int[] nums) {
		if (nums.length == 0) return 0;

		int[] dp = new int[nums.length];
		dp[0] = 0;

		int max = 0;

		for (int i = 0; i < nums.length; ++i){
			if (i + nums[i] > max){
				for (int j = max + 1; j <= i + nums[i] && j < nums.length; ++j) dp[j] = dp[i] + 1;
				max = i + nums[i];
				if (max >= nums.length) break;
			}
		}
		return dp[nums.length - 1];
	}
}
