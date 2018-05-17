import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();

		Scanner in = new Scanner(System.in);

		String s = in.next();

		System.out.println(solution.solve(s) ? "YES" : "NO");
	}

	private boolean solve(String s){
		int[] c = new int[26];
		for (int i = 0; i < s.length(); ++i){
			++c[s.charAt(i) - 'a'];
		}

		boolean found = false;
		int count = 0;
		int f = -1;
		for (int i = 0; i < 26; ++i){
			if (c[i] == 0) continue;
			if (f == -1) {
				f = c[i];
				count = 1;
				continue;
			}
			if (f == c[i]) {
				++count;
				continue;
			}
			if (found && f != c[i]) return false;
			if (f == c[i] - 1 || c[i] == 1) {
				found = true;
				continue;
			}
			if (f == c[i] + 1){
				if (count == 1) {
					f = c[i];
					found = true;
					continue;
				}
				else return false;
			}
			return false;
		}
		return true;
	}
}
