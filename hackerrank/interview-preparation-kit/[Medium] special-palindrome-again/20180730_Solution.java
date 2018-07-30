import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();

		int count = 0;
		for (int i = 0; i < n; ++i) {
			for (int k = 0; k <= i && i + k < n; ++k) {
				if (s.charAt(i - k) != s.charAt(i + k)) break;
				if (k > 1 && s.charAt(i - k) != s.charAt(i - k + 1)) break;
				++count;
			}
		}
		for (int i = 0; i < n - 1; ++i) {
			for (int k = 0; k <= i && i + k + 1 < n; ++k) {
				if (s.charAt(i - k) != s.charAt(i) || s.charAt(i + k + 1) != s.charAt(i)) break;
				++count;
			}
		}
		System.out.println(count);
	}
}
