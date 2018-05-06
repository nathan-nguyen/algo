class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums.length == 0) return new ArrayList<>();

		Arrays.sort(nums);

		List<List<Integer>> dp = new ArrayList<>();
		List<Integer> dp0 = new ArrayList<>();
		dp0.add(nums[0]);
		dp.add(dp0);

		int maxIndex = 0;
		for (int i = 1; i < nums.length; ++i){
			int prevIndex = -1;
			int max = 1;
			for (int j = 0; j < i; ++j){
				if (nums[i] % nums[j] == 0 && dp.get(j).size() + 1 > max) {
					prevIndex = j;
					max = dp.get(j).size() + 1;
				}
			}

			List<Integer> dpi = new ArrayList<>();

			if (prevIndex >= 0) dpi.addAll(dp.get(prevIndex));
			dpi.add(nums[i]);
			dp.add(dpi);

			if (dpi.size() > dp.get(maxIndex).size()) maxIndex = i;
		}

		return dp.get(maxIndex);
	}
}
