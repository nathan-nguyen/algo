import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		while (t -- > 0){
			String s = in.next();
			int n = in.nextInt();
			solve(s, n);
		}
	}
	
	private void solve(String s, int n){
		if (n == 1) {
			System.out.println(s);
			return;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n ; ++i){
			for (int j = i, inc = (2 * (n - 1) - 2 * i); j < s.length(); j += inc, inc = 2 * (n - 1) - inc){
				if (inc == 0) continue;
				sb.append(s.charAt(j));
			}
		}
		System.out.println(sb);
	}
}

