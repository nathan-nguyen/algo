import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		String s = in.next();

		int count = 0;

		int local = 0;
		int total = 0;
		for (int i = 0; i < s.length(); ++i) {
			int c = s.charAt(i) - '0';
			if (c % 3 == 0 || (total + c) % 3 == 0) {
				++count;
				local = total = 0;
			}
			else {
				++local;
				total += c;
			}

			if (local == 3) {
				++count;
				local = total = 0;
			}
		}

		System.out.println(count);
	}
}
