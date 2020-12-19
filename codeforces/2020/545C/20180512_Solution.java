import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] tList = new int[n][2];

		for (int i = 0; i < n; ++i){
			tList[i][0] = in.nextInt();
			tList[i][1] = in.nextInt();	
		}

		int[] left = new int[n];
		int[] right = new int[n];

		if (n == 1) {
			System.out.println(1);
			return;
		}

		left[0] = 1;
		right[0] = (tList[0][0] + tList[0][1] < tList[1][0]) ? 1 : 0;

		for (int i = 1; i < n - 1; ++i){
			left[i] = Math.max(left[i-1], right[i-1]);
			if (tList[i][0] - tList[i][1] > tList[i-1][0]) left[i] = Math.max(left[i], 1 + left[i-1]);
			if (tList[i][0] - tList[i][1] > tList[i-1][0] + tList[i-1][1]) left[i] = Math.max(left[i], 1 + right[i-1]);

			right[i] = Math.max(left[i-1], right[i-1]);
			if (tList[i][0] + tList[i][1] < tList[i+1][0]) right[i]++;
		}

		System.out.println(Math.max(left[n-2], right[n-2]) + 1);
	}
}
