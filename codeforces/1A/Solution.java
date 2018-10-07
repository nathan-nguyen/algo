import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int a = in.nextInt();

		System.out.println((long)(n / a + (n % a == 0 ? 0 : 1)) * (m / a + (m % a == 0 ? 0 : 1)));
	}
}
