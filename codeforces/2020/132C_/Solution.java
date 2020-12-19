import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = in.nextInt();
		int m = s.length();

		int[][][] l = new int[m][n + 1][2];
		int[][][] r = new int[m][n + 1][2];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j <= n; ++j) {
				l[i][j][0] = l[i][j][1] = 1000;
				r[i][j][0] = r[i][j][1] = -1000;
			}
		}

		int distance = 0, direction = 0;
		for (int i = 0; i < m; ++i) {
			if (s.charAt(i) == 'T') direction = 1 - direction;
			else distance += 1 - 2 * direction;
			l[i][0][direction] = r[i][0][direction] = distance;
		}

		for (int i = 1; i <= n; ++i) {
			if (s.charAt(0) == 'F') {
				if (i % 2 == 0) l[0][i][0] = r[0][i][0] = 1;
				else l[0][i][1] = r[0][i][1] = 0;
			} else {
				if (i % 2 == 0) l[0][i][1] = r[0][i][1] = 0;
				else l[0][i][0] = r[0][i][0] = 1;
			}
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (s.charAt(i) == 'F') {
					l[i][j][0] = Math.min(l[i-1][j][0] + 1, l[i-1][j-1][1]);
					r[i][j][0] = Math.max(r[i-1][j][0] + 1, r[i-1][j-1][1]);
					l[i][j][1] = Math.min(l[i-1][j][1] - 1, l[i-1][j-1][0]);
					r[i][j][1] = Math.max(r[i-1][j][1] - 1, r[i-1][j-1][0]);
				} else {
					l[i][j][0] = Math.min(l[i-1][j][1], l[i-1][j-1][0] + 1);
                                        r[i][j][0] = Math.max(r[i-1][j][1], r[i-1][j-1][0] + 1);
                                        l[i][j][1] = Math.min(l[i-1][j][0], l[i-1][j-1][1] - 1);
                                        r[i][j][1] = Math.max(r[i-1][j][0], r[i-1][j-1][1] - 1);
				}
			}
		}

		int max = 0;
		if (Math.abs(l[m-1][n][0]) <= m) max = Math.max(max, Math.abs(l[m-1][n][0]));
		if (Math.abs(l[m-1][n][1]) <= m) max = Math.max(max, Math.abs(l[m-1][n][1]));
		if (Math.abs(r[m-1][n][0]) <= m) max = Math.max(max, Math.abs(r[m-1][n][0]));
		if (Math.abs(r[m-1][n][1]) <= m) max = Math.max(max, Math.abs(r[m-1][n][1]));
		System.out.println(max);
	}
}
