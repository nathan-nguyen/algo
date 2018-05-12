import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		if (m >= 2 * n) System.out.println(n);
		else if (n >= 2 * m) System.out.println(m);
		else System.out.println((n+m) / 3);
	}
}
