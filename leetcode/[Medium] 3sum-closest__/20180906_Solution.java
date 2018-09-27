class Solution {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;

		int min = nums[0] + nums[1] + nums[2];

		for (int i = 0; i < n - 2; ++i){
			int start = i + 1;
			int end = n - 1;

			while (start < end){
				int sum = nums[i] + nums[start] + nums[end];
				if (sum >= target) --end;
				if (sum < target) ++start;
				if (Math.abs(min - target) > Math.abs(sum - target)) min = sum;	
			}
		}
		return min;
	}

}
