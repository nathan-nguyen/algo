import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[][] o = new int[n][n];
		int[][] g = new int[n][n];
		int[] a = new int[n];
		long[] total = new long[n];

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n; ++j) o[i][j] = in.nextInt();
		}

		for (int i = n-1; i >= 0; --i) a[i] = in.nextInt() - 1;

		for (int k = 0; k < n; ++k){
			total[k] = 0;
			for (int i = 0; i < k; ++i){
				g[k][i] = o[a[k]][a[i]];
				g[i][k] = o[a[i]][a[k]];
				for (int j = 0; j < k; ++j){
					if (i != j) {
						g[i][k] = Math.min(g[i][k], g[i][j] + o[a[j]][a[k]]);
						g[k][i] = Math.min(g[k][i], o[a[k]][a[j]] + g[j][i]);
					}
				}
			}

			for (int i = 0; i < k; ++i){
				for (int j = 0; j < k; ++j){
					g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
				}
			}

			for (int i = 0; i <= k; ++i){
				for (int j = 0; j <= k; ++j) total[k] += g[i][j];
			}
			
		}

		for (int i = n - 1; i >= 0; --i) System.out.print(total[i] + " ");
		System.out.println();
		
	}
}
