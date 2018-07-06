import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[][] a = new int[6][6];

		for (int i = 0; i < 6; ++i) {
			for (int j = 0; j < 6; ++j) a[i][j] = in.nextInt();
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; ++i){
			for (int j = 0; j < 4; ++j){
				int total = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
				max = Math.max(max, total);
			}
		}

		System.out.println(max);
		in.close();
	}
}
