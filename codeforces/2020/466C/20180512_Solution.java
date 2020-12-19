import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		
		long total = 0;
		for (int i = 0; i < n; ++i){
			a[i] = in.nextInt();
			total += a[i];
		}

		if (n < 3 || total % 3 != 0){
			System.out.println(0);
			return;
		}

		long result = 0;
		long localTotal = 0;
		int count = 0;
		for (int i = 0; i < n; ++i){
			localTotal += a[i];
			if (localTotal == total / 3 * 2 && i > 0 && i < n-1) result += count;
			if (localTotal == total / 3) ++count;
		}
		System.out.println(result);
	}
}
