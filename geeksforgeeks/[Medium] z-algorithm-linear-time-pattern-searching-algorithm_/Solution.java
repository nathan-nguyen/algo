import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String s = in.next();
		String key = in.next();

		Solution solution = new Solution();
		System.out.println(solution.find(s, key) + " " + s.indexOf(key));
	}

	private int find(String s, String key) {
		StringBuilder sb = new StringBuilder();
		sb.append(key);	sb.append('$');	sb.append(s);
		s = sb.toString();

		int l = 0;	int r = 0;

		int[] z = new int[s.length()];
		for (int i = 1; i < s.length(); ++i) {
			if (i > r) {
				l = r = i;
				while (r < s.length() && s.charAt(r - l) == s.charAt(r)) ++r;
				z[i] = r - l;
				--r;
			}
			else {
				int k = i - l;
				if (z[k] < r - i + 1) z[i] = z[k];
				else {
					l = i;
					while (r < s.length() && s.charAt(r - l) == s.charAt(r)) ++r;
					z[i] = r - l;
					--r;
				}
			}

			if (z[i] == key.length()) return i - key.length() - 1;
		}	
		return -1;
	}
}
