import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solve());
	}

	private int solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int[] p = new int[n];
		for (int i = 0; i < n; ++i) p[i] = in.nextInt();

		Arrays.sort(p);
		for (int i = 0; i < n; ++i) {
			if (k < p[i]) return i;
			k -= p[i];
		}
		return n;
	}
}
