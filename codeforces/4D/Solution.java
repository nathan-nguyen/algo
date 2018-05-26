import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int w = in.nextInt();
		int h = in.nextInt();

		int[][] e = new int[n+1][3];

		e[0][0] = w;
		e[0][1] = h;
		e[0][2] = 0;

		for (int i = 1; i <= n; ++i){
			e[i][0] = in.nextInt();
			e[i][1] = in.nextInt();
			e[i][2] = i;
		}

		Arrays.sort(e, new Comparator<int[]>(){
			@Override public int compare(int[] o1, int[] o2){
				return -Double.compare((long)o1[0] * o1[1], (long)o2[0] * o2[1]);
			}
		});

		int[][] dp = new int[n+1][2];

		int num = 0;
		int env = -1;

		for (int i = 0; i <= n; ++i){
			dp[i][0] = 1;
			dp[i][1] = i;

			for (int j = 0; j < i; ++j){
				if (e[j][0] > e[i][0] && e[j][1] > e[i][1] && dp[j][0] + 1 > dp[i][0]){
					dp[i][0] = dp[j][0] + 1;
					dp[i][1] = j;
				}
			}

			if (e[i][2] == 0){
				num = dp[i][0] - 1;
				env = dp[i][1];
			}
		}

		System.out.println(num);

		for (int i = 0; i < num; ++i){
			System.out.print(e[env][2] + " ");
			env = dp[env][1];
		}
		if (num > 0) System.out.println();
	}
}
