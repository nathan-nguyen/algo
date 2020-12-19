import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long m = in.nextLong();

		if (n <= m) System.out.println(n);
		else {
			long k = (long) Math.sqrt(2 * (n - m));
			if (k * (k + 1) < 2 * (n - m)) ++k;
			System.out.println(m + k);
		}
	}
}
