import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private int swapCount = 0;
	private int[] arr;

	private void solve() {
		Scanner in = new Scanner (System.in);
		int n = in.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; ++i) arr[i] = in.nextInt();

		for (int i = n - 1; i >= 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (arr[j] > arr[j + 1]) swap(j, j + 1);
			}
		}
		System.out.printf("Array is sorted in %d swaps.\nFirst Element: %d\nLast Element: %d", swapCount, arr[0], arr[n-1]);
	}

	private void swap(int i, int j) {
		++swapCount;
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}
}
