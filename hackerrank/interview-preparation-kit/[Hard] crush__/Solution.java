import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n+1];

		int m = in.nextInt();

		while (m -- > 0) {
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			int k = in.nextInt();

			arr[a] += k;
			arr[b + 1] -= k; 
		}

		long max = Integer.MIN_VALUE;
		long value = 0;
		for (int i = 0; i < n; ++i){
			value += arr[i];
			max = Math.max(max, value);
		}
		System.out.println(max);

		in.close();
	}
}
