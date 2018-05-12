import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		int[] range = new int[n + 2];
		range[0] = 0;
		range[n+1] = 1000000001;

		for (int i = 1; i <= n; ++i) range[i] = in.nextInt();

		Arrays.sort(range);

		int count = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 1; i < n + 2; ++i){
			for (int j = range[i-1] + 1; j < range[i]; ++j){
				if (j > m) break;
				result.append(j);
				result.append(" ");
				++count;
				m -= j;
			}
		}
		System.out.println(count);
		System.out.println(result);
	}
}
