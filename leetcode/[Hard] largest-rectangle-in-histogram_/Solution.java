class Solution {
	public int largestRectangleArea(int[] h) {
		Stack<Integer> stack = new Stack<>();

		int max = 0;
		for (int i = 0; i < h.length; ++i) {
			if (stack.size() == 0) stack.push(i);
			else {
				while (stack.size() > 0 && h[stack.peek()] > h[i]) {
					int k = stack.pop();
					int leftBound = stack.size() > 0 ? stack.peek() : -1;
					max = Math.max(max, h[k] * (i - leftBound - 1));
				}
				stack.push(i);
			}
		}
		while (stack.size() > 0) {
			int k = stack.pop();
			int leftBound = stack.size() > 0 ? stack.peek() : -1;
			max = Math.max(max, h[k] * (h.length - leftBound - 1));
		}
		return max;
	}
}
