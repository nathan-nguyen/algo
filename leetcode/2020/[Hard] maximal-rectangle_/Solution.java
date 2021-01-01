class Solution {
	public int maximalRectangle(char[][] g) {
		if (g.length == 0 || g[0].length == 0) return 0;

		int n = g.length;
		int m = g[0].length;

		int[] h = new int[m];

		int max = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) h[j] = g[i][j] == '1' ? h[j] + 1 : 0;

			max = Math.max(max, maximalRectangle(m, h));			
		}
		return max;
	}

	private int maximalRectangle(int n, int[] h) {
		Stack<Integer> stack = new Stack<>();

		int max = 0;
		for (int i = 0; i < n; ++i) {
			while (stack.size() > 0 && h[stack.peek()] > h[i]) {
				int k = stack.pop();
				int leftExclusive = stack.size() > 0 ? stack.peek() : -1;
				max = Math.max(max, (i - leftExclusive - 1) * h[k]);
			}
			stack.push(i);
		}

		while (stack.size() > 0) {
			int k = stack.pop();
			int leftExclusive = stack.size() > 0 ? stack.peek() : -1;
			max = Math.max(max, (n - leftExclusive - 1) * h[k]);
		}
		return max;
	}
}
