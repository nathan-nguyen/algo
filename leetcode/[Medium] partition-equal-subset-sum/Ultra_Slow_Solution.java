class Solution {
	public boolean canPartition(int[] nums) {
		int sum = 0;

		for (int i: nums) sum += i;
		if (sum % 2 == 1) return false;

		sum /= 2;
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; ++i) {
			List<Integer> list = new LinkedList<>();
			if (nums[i] <= sum) list.add(nums[i]);
			for (int k: set) {
				if (k + nums[i] <= sum) list.add(k + nums[i]);
			}
			set.addAll(list);
		}

		return set.contains(sum);
	}
}
