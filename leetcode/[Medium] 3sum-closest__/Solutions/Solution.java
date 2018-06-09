class Solution {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;

		int min = nums[0] + nums[1] + nums[2];

		for (int i = 0; i < n-2; ++i){
			int total = nums[i] + twoSum(nums, i + 1, target - nums[i]);
			if (Math.abs(total - target) < Math.abs(min - target)) min = total;
		}
		return min;
	}

	// Guarantee start < a.length - 1
	private int twoSum(int[] a, int start, int target){
		int end = a.length - 1;
		int min = a[start] + a[end];
		int total = a[start] + a[end];
		while (start < end){
			while (total <= target && start < end){
				if (Math.abs(min - target) > Math.abs(total - target)) min = total;
				if (start + 1 < end) total = total - a[start] + a[start + 1];
				++start;
			}
			if (Math.abs(min - target) > Math.abs(total - target)) min = total;
			if (end - 1 > start) total = total - a[end] + a[end - 1];
			--end;
		}
		return min;	
	}
}
