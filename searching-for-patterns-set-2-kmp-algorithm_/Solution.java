import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		String p = in.nextLine();

		int[] lps = new int[p.length()];
		preprocess(p, lps);

		int j = 0;
		for (int i = 0; i < s.length(); ++i){
			while(s.charAt(i) != p.charAt(j) && j > 0) j = lps[j];
			if (s.charAt(i) == p.charAt(j)) ++j;
			if (j == p.length()) {
				System.out.println(i - j + 1);
				j = lps[j-1];
			}
		}
	}

	private void preprocess(String p, int[] lps){
		lps[0] = 0;

		int len = 0;
		for (int i = 1; i < lps.length; ++i){
			while (p.charAt(len) != p.charAt(i) && len > 0) {
				len = lps[len - 1];
			}
			if (p.charAt(len) == p.charAt(i)) lps[i] = ++len;
			else lps[i] = 0;
		}
	}
	
}
