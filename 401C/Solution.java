import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		if (n > m + 1 || 2 * n + 2 < m) {
			System.out.println(-1);
			return;
		}

		StringBuilder result = new StringBuilder();

		// 010 - 0101
		if ( m == n - 1 || m == n){
			for (int i = 0; i < m; ++i) result.append("01");
			if (m == n - 1) result.append(0);
		}

		else if (m == 2 * n + 2) {
			for (int i = 0; i < n; ++i) result.append("110");
			result.append("11");
		}

		// 10101 - 110101
		else if ( m >= n + 1) {
			int k = m - n - 1;
			for (int i = 0; i < k ; ++i) result.append("110");
			for (int i = 0; i < m - 2 * k - 1; ++i) result.append("10");
			result.append(1);
		}
		System.out.println(result);
	}
}
