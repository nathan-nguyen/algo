import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int t = in.nextInt();

		Solution solution = new Solution();

		while (t -- > 0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) arr[i] = in.nextInt();

			System.out.println(solution.solve(arr, n));	
		}
	}

	private int solve(int[] arr, int n) {
		int result = 0;
		int count = 0;

		for (int i = 0; i < n; ++i) {
			if (arr[i] == 0) ++count;
			else if (count > 0) {
				if (result == 0 && count == i) result = count;
				else result = Math.max(result, (count + 1) / 2);
				count = 0;
			}
		}

		if (count == n) return -1;

		result = Math.max(result, count);
		return result;
	}
}
