class Solution {
	public int maximalRectangle(char[][] map) {
		if (map.length == 0 || map[0].length == 0) return 0;
		int n = map.length;
		int m = map[0].length;

		int[] h = new int[m];
		for (int i = 0; i < m; ++i) h[i] = map[0][i] == '1' ? 1 : 0;
		int max = largestRectangleArea(h);

		for (int i = 1; i < n; ++i){
			for (int j = 0; j < m; ++j){
				if (map[i][j] == '1') ++h[j];
				else h[j] = 0;
			}
			max = Math.max(max, largestRectangleArea(h));
		}
		return max;
	}

        private int largestRectangleArea(int[] h) {
                Stack<int[]> stack = new Stack<>();

                int max = 0;
                for (int i = 0; i < h.length; ++i) {
                        while (stack.size() > 0 && stack.peek()[0] > h[i]){
                                int[] val = stack.pop();
                                int index = 0;
                                if (stack.size() == 0) index = -1;
                                else index = stack.peek()[1];
                                max = Math.max(max, val[0] * (i - index - 1));
                        }

                        if (stack.size() > 0 && stack.peek()[0] == h[i]) stack.pop();
                        stack.push(new int[] {h[i], i});
                }

                while (stack.size() > 0){
                        int[] val = stack.pop();
                        int index = 0;
                        if (stack.size() == 0) index = -1;
                        else index = stack.peek()[1];
                        max = Math.max(max, val[0] * (h.length - index - 1));
                }
                return max;
        }
}
