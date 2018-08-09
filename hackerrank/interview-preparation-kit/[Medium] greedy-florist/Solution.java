import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int[] c = new int[n];
		for (int i = 0; i < n; ++i) c[i] = in.nextInt();

		Arrays.sort(c);
		int next = 0;
		long total = 0;
		for (int i = c.length - 1; i >= 0; --i) {
			total += (next++ / k + 1) * c[i];
		}
		System.out.println(total);
	}
}
