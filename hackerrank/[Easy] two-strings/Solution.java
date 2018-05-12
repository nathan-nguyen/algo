import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();

		while (q -- > 0) {
			String s1 = in.next();
			String s2 = in.next();

			System.out.println(solve(s1, s2) ? "YES" : "NO");
		}
	}

	private boolean solve(String s1, String s2){
		boolean[] c = new boolean[26];

                for (int i = 0; i < s1.length(); ++i) c[s1.charAt(i) - 'a'] = true;

                for (int i = 0; i < s2.length(); ++i){
                        if (c[s2.charAt(i) - 'a']) {
                                return true;
                        }   
                }   
                return false;
	}
}
