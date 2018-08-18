import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] h = new int[n];
		for (int i = 0; i < n; ++i) h[i] = in.nextInt();

		long max = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; ++i) {
			while (stack.size() > 0 && h[stack.peek()] > h[i]) {
				int index = stack.pop();
				int leftExclusive = (stack.size() == 0) ? -1 : stack.peek();
				max = Math.max(max, (long) h[index] * (i - leftExclusive - 1));
			}
			stack.push(i);
		}

		while (stack.size() > 0) {
			int index = stack.pop();
			int leftExclusive = (stack.size() == 0) ? -1 : stack.peek();
			max = Math.max(max, (long) h[index] * (n - leftExclusive - 1));
		}

		System.out.println(max);
	}
}
