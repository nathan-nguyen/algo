class Solution {
	public int largestRectangleArea(int[] h) {
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
