import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();

		int[] a = new int[k];

		while (n -- > 0) ++a[in.nextInt() % k];

		if (k == 1) {
			System.out.println(1);
			return;
		}

		int sum = (a[0] > 0) ? 1 : 0;

		for (int i = 1; i <= (k-1) / 2; ++i) sum += Math.max(a[i], a[k - i]);

		if (k % 2 == 0 && a[k / 2] > 0) ++sum;

		System.out.println(sum);
	}
}
