import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int w = in.nextInt();
		int h = in.nextInt();

		int[][] e = new int[n][3];

		for (int i = 0; i < n; ++i){
			e[i][0] = in.nextInt();
			e[i][1] = in.nextInt();
			e[i][2] = i+1;
		}

		Arrays.sort(e, new Comparator<int[]>(){
			@Override public int compare(int[] o1, int[] o2){
				return Float.compare((long)o1[0] * o1[1], (long)o2[0] * o2[1]);
			}
		});

		int[] dp = new int[n];
		int[] last = new int[n];

		int maxIndex = -1;

		for (int i = 0; i < n; ++i){
			if (e[i][0] <= w || e[i][1] <= h) continue;

			dp[i] = 1;
			last[i] = -1;

			for (int j = 0; j < i; ++j){
				if (dp[j] > 0 && e[i][0] > e[j][0] && e[i][1] > e[j][1] && dp[i] < dp[j] + 1){
					dp[i] = dp[j] + 1;
					last[i] = j;
				}
			}

			if (maxIndex == -1 || dp[i] > dp[maxIndex]) maxIndex = i;
		}

		if (maxIndex == -1) System.out.println(0);
		else {
			System.out.println(dp[maxIndex]);
			String result = "";
			while (maxIndex != -1) {
				result = e[maxIndex][2] + " " + result;
				maxIndex = last[maxIndex];
			}
			System.out.println(result);
		}
	}
}
