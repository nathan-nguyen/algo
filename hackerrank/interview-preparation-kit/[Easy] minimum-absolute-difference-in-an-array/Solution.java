import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) arr[i] = in.nextInt();

		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; ++i) min = Math.min(min, arr[i+1] - arr[i]);

		System.out.println(min);
	}
}
