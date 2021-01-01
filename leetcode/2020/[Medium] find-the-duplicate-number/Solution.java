public class Solution {
    public int findDuplicate(int[] nums) {
	if (nums.length == 0) return -1;

        int slow = 0;
        int fast = 0;

	while (true){
		if (nums[fast] >= nums.length || nums[nums[fast]] >= nums.length) return -1;
		fast = nums[nums[fast]];
		slow = nums[slow];

		if (fast == slow) {
			if (fast == nums[0]) return nums[0];

			fast = 0;
			while (true) {
				fast = nums[fast];
				slow = nums[slow];
				if (fast == slow) return fast;
			}
		}
	}
    }
}


