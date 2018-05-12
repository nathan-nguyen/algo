class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (n == 0) return new int[0];
		// k is always positive

		int[] r = new int[n - k + 1];
	
		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < n; ++i){
			while (dq.size() > 0 && dq.peek() < i - k + 1) dq.poll();

			while (dq.size() > 0 && nums[dq.peekLast()] < nums[i]) dq.pollLast();

			dq.offer(i);
			if (i >= k - 1) r[i - k + 1] = nums[dq.peek()];
		}
		return r;
	}
}

