class Solution {
	public double[] medianSlidingWindow(int[] nums, int k) {
		// We dont allow duplicate value in TreeSet
		Comparator<Integer> comparator = (u, v) -> (nums[u] == nums[v]) ? u - v : Integer.compare(nums[u],nums[v]);
		TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
		TreeSet<Integer> right = new TreeSet<>(comparator);

		Supplier<Double> median = (k % 2 == 0) ?
			() -> ((double) nums[left.first()] + nums[right.first()]) / 2 :
			() -> (double) nums[right.first()];

		// Balance lefts size and rights size (if not equal then right will be larger by one)
		Runnable balance = () -> { while (left.size() > right.size()) right.add(left.pollFirst()); };

		double[] result = new double[nums.length - k + 1];
		
		for (int i = 0; i < k; ++i) left.add(i);
		balance.run();	result[0] = median.get();

		for (int i = k; i < nums.length; ++i){
			if (!left.remove(i - k)) right.remove(i - k);

			right.add(i);	left.add(right.pollFirst());

			balance.run();	result[i - k + 1] = median.get();
		}
		return result;
	}
}
