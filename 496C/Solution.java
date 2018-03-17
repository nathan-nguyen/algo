import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		String[] data = new String[n];
		String[] result = new String[n];

		for (int i = 0; i < n; ++i) {
			data[i] = in.next();
			result[i] = "";
		}

		for (int i = 0; i < m; ++i) processCol(data, result, i, n);

		System.out.println(m - result[0].length());
	}

	public static boolean processCol(String[] data, String[] result, int col, int n){
		for (int i = 1; i < n; ++i){
			if ((result[i] + data[i].charAt(col)).compareTo(result[i-1] + data[i-1].charAt(col)) < 0) return false;
		}
		
		for (int i = 0; i < n; ++i) result[i] += data[i].charAt(col);
		return true;
	}
}
