import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve(); 
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		String n = in.next();
		int k = in.nextInt();
		System.out.println(calculate(n, k));
	}

	private int calculate(String n, int k) {
		return calculate((long) getTotal(n) * k);
	}

	private int getTotal(String n) {
		int total = 0;
		for (int i = 0; i < n.length(); ++i) total += n.charAt(i) - '0';

		return total;
	}

	private int calculate(long n) {
		if (n < 10) return (int) n;
		long total = 0;
		while (n != 0) {
			total += n % 10;
			n /= 10;
		}
		return calculate(total);
	}
}
