import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
                int n = in.nextInt();

                while (n -- > 0){
                        String s = in.next();
			System.out.println(isBalance(s) ? "YES" : "NO");
                }
	}

	private boolean isBalance(String s){
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); ++i){
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') stack.push(c);
			else {
				if (stack.isEmpty()) return false;
				if (c == ')' && stack.peek() != '(') return false;
				if (c == ']' && stack.peek() != '[') return false;
				if (c == '}' && stack.peek() != '{') return false;
				stack.pop();
			}
		}

		return stack.isEmpty();
	}
}

