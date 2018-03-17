import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int s = in.nextInt();

		solve(m, s);
	}

	private static void solve(int m, int s){
		if (m * 9 < s || (s == 0 && m > 1)){
			System.out.println("-1 -1");
			return;
		}

		if (m == 1 && s == 0) {
			System.out.println("0 0");
			return;
		}

		StringBuilder max = new StringBuilder();
		for (int i = 0; i < s / 9; ++i) max.append(9);
		if (s % 9 != 0) max.append(s % 9);
		for (int i = s / 9 + (s % 9 == 0 ? 0 : 1); i < m; ++i) max.append(0);
		
		StringBuilder min = new StringBuilder();

		int z = (s - 1) / 9;
		int k = (s - 1) % 9;

		if (z + (k == 0 ? 0 : 1) < m) min.append(1);
		else ++k;

		for (int i = 0; i < m - 1 - z - (k == 0 ? 0 : 1); ++i) min.append(0);

		if (k != 0) min.append(k);

		for (int i = 0; i < z; ++i) min.append(9);
		
		System.out.println(min.toString() + " " + max.toString());
	}
}
