import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; ++i) arr[i] = in.nextInt();

		long max = -1;
		String result = "";

		Arrays.sort(arr);
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				for (int k = j + 1; k < n; ++k) {
					long p = (long)arr[i] + arr[j] + arr[k];
					if (arr[i] + arr[j] > arr[k] && p > max) {
						max = p;
						result = arr[i] + " " + arr[j] + " " + arr[k];
					}
				}
			}
		}
		System.out.println(max == -1 ? max : result);
	}
}
