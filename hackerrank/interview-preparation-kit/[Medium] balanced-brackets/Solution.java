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

		while (n -- > 0) {
			String s = in.next();
			System.out.println(solve(s) ? "YES" : "NO");
		}
	}

	private boolean solve(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c == '{' || c == '(' || c == '[') stack.push(c);
			else if (c == '}' && (stack.size() == 0 || stack.pop() != '{')) return false;
			else if (c == ')' && (stack.size() == 0 || stack.pop() != '(')) return false;
			else if (c == ']' && (stack.size() == 0 || stack.pop() != '[')) return false;
		}
		return stack.size() == 0;
	}
}
