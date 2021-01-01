class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		int begin = 0, end = 0;
		int d = Integer.MAX_VALUE;

		int total = 0;
		while (end < nums.length){
			total += nums[end++];
			while (total >= s){
				d = Math.min(d, end - begin);
				total -= nums[begin++];
			}
		}
		return d == Integer.MAX_VALUE ? 0 : d;
	}
}
