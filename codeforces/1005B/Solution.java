import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String t = in.next();

		int count = 0;
		while (count < s.length() && count < t.length()) {
			if (s.charAt(s.length() - 1 - count) != t.charAt(t.length() - 1 - count)) break;
			++count;
		}

		System.out.println(s.length() + t.length() - 2 * count);
	}
}
