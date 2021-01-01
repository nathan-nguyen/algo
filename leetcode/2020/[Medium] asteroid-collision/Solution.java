class Solution {
	public int[] asteroidCollision(int[] a) {
		Stack<Integer> stack = new Stack<>();

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < a.length; ++i){
			if (a[i] > 0) stack.push(a[i]);
			else {
				while (stack.size() > 0 && stack.peek() < -a[i]) stack.pop();
				if (stack.size() == 0) result.add(a[i]);
				else if (stack.peek() == -a[i]) stack.pop();
			}
		}
		int length = result.size();
		while (stack.size() > 0) result.add(length, stack.pop());
		return result.stream().mapToInt(i->i).toArray();
	}
}
