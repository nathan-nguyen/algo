import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int d = in.nextInt() % n;
		int[] a = new int[n];

		for (int i = 0; i < n; ++i) a[i] = in.nextInt();

		for (int i = 0; i < n; ++i) System.out.print(a[(i + d) % n] + " ");
		System.out.println();

		in.close();
	}
}
