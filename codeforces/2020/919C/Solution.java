import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		String[] data = new String[n];
		for (int i = 0; i < n; ++i) data[i] = in.next();

		long result = 0;
		for (int i = 0; i < n; ++i){
			int streak = 0;
			for (int j = 0; j < m; ++j){
				if (data[i].charAt(j) == '*') {
					result += Math.max(0, streak - k + 1);
					streak = 0;
				}
				else ++streak;
			}
			result += Math.max(0, streak - k + 1);
		}

		if (k == 1){
			System.out.println(result);
			return;
		}

		for (int i = 0; i < m; ++i){
			int streak = 0;
			for (int j = 0; j < n; ++j){
				if (data[j].charAt(i) == '*'){
					result += Math.max(0, streak - k + 1);
					streak = 0;
				}
				else ++streak;
			}
			result += Math.max(0, streak - k + 1);
		}
		System.out.println(result);
	}
} 
