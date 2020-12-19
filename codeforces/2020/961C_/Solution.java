import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		String[][] chess = new String[4][n];
		int[][] r = new int[4][2];

		int total1 = 0;

		for (int i = 0; i < 4; ++i){
			for (int  j = 0; j < n; ++j) chess[i][j] = in.next();

			for (int j = 0; j < n; ++j){
				for (int k = 0; k < n; ++k){
					int c = chess[i][j].charAt(k) - '0';
					r[i][0] += (j + k) % 2 == 0 ? c : 1 - c;
					r[i][1] += (j + k) % 2 == 0 ? 1 - c : c;
				}
			}

			total1 += r[i][1];
		}

		int min = 40001;
		for (int i = 0; i < 3; ++i){
			for (int j = i + 1; j < 4; ++j){
				min = Math.min(min, r[i][0] + r[j][0] + total1 - r[i][1] - r[j][1]);
			}
		}
		System.out.println(min);
	}
}
