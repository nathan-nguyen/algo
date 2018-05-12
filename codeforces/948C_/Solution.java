import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] v = new int[n];
		int[] t = new int[n];

		for (int i = 0; i < n; ++i) v[i] = in.nextInt();
		for (int i = 0; i < n; ++i) t[i] = in.nextInt();

		for (int i = 0; i < n; ++i){
			int tp = t[i];
			int total = 0;
			for (int j = 0; j <= i; ++j){
				if (v[j] == 0) continue;
				if (v[j] <= tp) total += v[j];
				else total += tp;
				v[j] = Math.max(0, v[j] - tp);
			}
			System.out.print(total + " ");
		}
		System.out.println();
	}
}
