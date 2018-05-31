class Solution {
	public int majorityElement(int[] nums) {
		int count = 0;

		int n = nums[0];
		
		for (int k: nums){
			if (count == 0){
				count = 1;
				n = k;
			}
			else if (n == k) ++count;
			else --count;
		}

		return n;
	}
}
