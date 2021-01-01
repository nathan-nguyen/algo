class Solution {
	public int[] searchRange(int[] nums, int target) {
		return new int[]{leftSearch(nums, target, 0, nums.length - 1), rightSearch(nums, target, 0, nums.length - 1)};
	}

	private int leftSearch(int[] nums, int target, int low, int high){
		if (low > high) return -1;
		if (low == high) return nums[low] == target ? low : -1;

		int mid = (low + high) / 2;

		if (nums[mid] == target) return leftSearch(nums, target, low, mid);
		else if (nums[mid] < target) return leftSearch(nums, target,mid + 1, high);
		else return leftSearch(nums, target, low, mid - 1);
	}

	private int rightSearch(int[] nums, int target, int low, int high){
                if (low > high) return -1; 
                if (low == high) return nums[low] == target ? low : -1; 

                int mid = (low + high) / 2;

		// if high = mid + 1 and target = nums[low] then --> stackOverFlow if we use rightSearch(nums, target, mid, high)
                if (nums[mid] == target) return Math.max(mid, rightSearch(nums, target, mid + 1, high));
                else if (nums[mid] < target) return rightSearch(nums, target,mid + 1, high);
                else return rightSearch(nums, target, low, mid - 1); 
        }
}
