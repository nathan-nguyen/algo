import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		// [0 - n] inclusive
		int[] range = new int[1000_001];
		range[0] = 1;
		for (int i = 1; i <= 1000_000; ++i) {
			range[i] = range[i-1] + (isSteppingNumber(i) ? 1 : 0);
		}

		while (t -- > 0) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(a == 0 ? range[b] : range[b] - range[a-1]);
		}
	}

	private boolean isSteppingNumber(int n) {
		int d = n % 10;
		n /= 10;
		while (n > 0) {
			int ld = n % 10;
			if (Math.abs(d - ld) != 1) return false;
			d = ld;
			n /= 10;
		}
		return true;
	}
}
