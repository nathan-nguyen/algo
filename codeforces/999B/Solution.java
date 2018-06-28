import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		String s = in.next();

		for (int i = 2; i <= n; ++i){
			if (n % i != 0) continue;
			s = (new StringBuilder(s.substring(0, i))).reverse().toString() + s.substring(i);
		}
		System.out.println(s);
	}
}
