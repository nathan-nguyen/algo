import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solve());
	}

	private int solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String s = in.next();

		boolean[] u = new boolean[26];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			int index = s.charAt(i) - 'a';
			if (u[index]) continue;

			u[index] = true;
			list.add(index + 1);
		}

		java.util.Collections.sort(list);

		int total = 0, last = -2;
		for (int c: list) {
			if (k <= 0) return total;
			if (c >= last + 2) {
				--k;
				total += c;
				last = c;
			}
		}
		
		if (k > 0) return -1;
		return total;
	}
}
