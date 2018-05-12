import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();

		while (q -- > 0){
			String s = in.next();
			System.out.println(makeAnagram(s));
		}
	}

	private int makeAnagram(String s){
		if (s.length() % 2 == 1) return -1;

		int[] c = new int[26];
		for (int i = 0; i < s.length(); ++i){
			c[s.charAt(i) - 'a'] += (i < s.length() / 2 ? 1 : -1);
		}

		int result = 0;
		for (int i = 0; i < 26; ++i) result += Math.abs(c[i]);
		return result / 2;
	}
}
