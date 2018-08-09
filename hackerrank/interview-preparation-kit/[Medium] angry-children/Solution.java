import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt() - 1;

		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) arr[i] = in.nextInt();

		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i + k < n; ++i) {
			min = Math.min(arr[i + k] - arr[i], min);
		}
		System.out.println(min);
	}
}
