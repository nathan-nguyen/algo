import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int g = in.nextInt();
		int[] arr = new int[n];

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i) {
			arr[i] = in.nextInt();
			max = Math.max(max, arr[i]);
		}

		System.out.println(binarySearch(arr, g, 0, (long) g * max));
	}

	private long binarySearch(int[] arr, int g, long start, long end) {
		if (start == end) return start;
		long mid = (start + end) / 2;

		long result = 0;
		for (int e: arr) result += mid / e;

		if (result >= g) return binarySearch(arr, g, start, mid);
		return binarySearch(arr, g, mid + 1, end);
	}
}
