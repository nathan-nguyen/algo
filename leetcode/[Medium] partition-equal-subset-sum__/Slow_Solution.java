class Solution {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i: nums) sum += i;

		if (sum % 2 == 1) return false;

		sum /= 2;
		boolean[] mem = new boolean[sum + 1];
		boolean[] newMem = new boolean[sum + 1];

		for (int i = 0; i < nums.length; ++i) {
			newMem = Arrays.copyOfRange(mem, 0, sum + 1);
			if (nums[i] <= sum) newMem[nums[i]] = true;

			for (int j = 1; j <= sum - nums[i]; ++j) {
				if (mem[j]) newMem[j + nums[i]] = true;
			}
			mem = newMem;
		}
		return mem[sum];
	}
}

