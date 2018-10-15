class Solution {
	public boolean find132pattern(int[] nums) {
		if (nums.length < 3) return false;
		int n = nums.length;

		int[] min = new int[n];
		min[0] = nums[0];

		for (int i = 1; i < n; ++i) min[i] = Math.min(min[i-1], nums[i]);

		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(nums[n-1]);

		for (int i = n - 2; i > 0; --i) {
			queue.offer(nums[i]);
			while (queue.size() > 0 && queue.peek() <= min[i - 1]) queue.poll();

			if (queue.size() > 0 && queue.peek() < nums[i]) return true;
		}
		return false;
	}
}
