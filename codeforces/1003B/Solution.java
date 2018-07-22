import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int b = in.nextInt();
		int a = in.nextInt();
		int x = in.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < (x + 1) / 2; ++i) sb.append("01");
		a -= (x + 1) / 2;
		b -= (x + 1) / 2;
		x -= ((x + 1) / 2) * 2 - 1;

		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < b; ++i) prefix.append('0');
		for (int i = 0; i < a; ++i) sb.append('1');

		if (x > 0) {
			if (b > 0) {
				prefix.setLength(prefix.length() - 1);
				sb.append('0');
			}
			else {
				sb.setLength(sb.length() - 1);
				if (prefix.length() > 0) prefix.setCharAt(0, '1');
				else prefix.append('1');
			}
		}
		System.out.println(prefix.toString() + sb.toString());
	}
}
