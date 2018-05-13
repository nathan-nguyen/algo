import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();

		int[] c = new int[26];
		for (int i = 0; i < s1.length(); ++i) ++c[s1.charAt(i) - 'a'];
		for (int i = 0; i < s2.length(); ++i) --c[s2.charAt(i) - 'a'];

		int count = 0;
		for (int i = 0; i < 26; ++i) count += Math.abs(c[i]);

		System.out.println(count);
	}
}

