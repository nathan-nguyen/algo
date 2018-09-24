import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solve());
	}

	private int solve() {
		Scanner in = new Scanner(System.in);
		int b = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();

		int[] k = new int[n];
		int[] d = new int[m];

		for (int i = 0; i < n; ++i) k[i] = in.nextInt();
		for (int i = 0; i < m; ++i) d[i] = in.nextInt();

		Arrays.sort(k);
		Arrays.sort(d);
		if (k[0] + d[0] > b) return -1;
		
		int ki = 0;
		int di = m - 1;
		int max = 0;

		while (ki < n && di >= 0) {
			if (k[ki] + d[di] > b) --di;
			else max = Math.max(max, k[ki++] + d[di]);
		}
		return max;
	}
}
