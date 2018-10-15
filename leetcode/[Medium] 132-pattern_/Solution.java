class Solution {
	public boolean find132pattern(int[] nums) {
		if (nums.length == 0) return false;
		int n = nums.length;

		int[] min = new int[n];
		min[0] = nums[0];

		for (int i = 1; i < n; ++i) min[i] = Math.min(min[i-1], nums[i]);

		Stack<Integer> stack = new Stack<>();
		stack.push(nums[n-1]);

		for (int i = n - 2; i > 0; --i) {
			while (!stack.isEmpty() && stack.peek() <= min[i - 1]) stack.pop();

			if (!stack.isEmpty() && stack.peek() < nums[i]) return true;

			// Stack is always sorted because all the element >= nums[i]
			stack.push(nums[i]);
		}
		return false;
	}
}

