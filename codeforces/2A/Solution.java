import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n -- > 0) System.out.println(solve(in.next()));
	}

	private String solve(String s) {
		List<String> rc = new ArrayList<>();
		List<String> nb = new ArrayList<>();
	
		boolean isRC = true;
		String ps = new String();

		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				if (!isRC) {
					nb.add(ps);
					ps = new String();
					isRC = true;
				}
			} else {
				if (isRC) {
					rc.add(ps);
					ps = new String();
					isRC = false;
				}
			}
			ps += s.charAt(i);
		}
		if (isRC) rc.add(ps);
		else nb.add(ps);

		if (rc.size() == 1) return "R" + nb.get(0) + "C" + toNumber(rc.get(0));
		return toString(Integer.parseInt(nb.get(1))) + nb.get(0);
	}

	private int toNumber(String s) {
		int ans = 0;

		for (int i = 0; i < s.length(); ++i) {
			ans = ans * 26 + s.charAt(i) - 'A' + 1;
		}
		return ans;
	}

	private String toString(int n) {
		String ans = new String();
		while (n > 26) {
			ans = (char)('A' + (n - 1) % 26) + ans;
			n = (n - 1) / 26;
		}
		return (char) ('A' + n - 1) + ans;
	}
}

