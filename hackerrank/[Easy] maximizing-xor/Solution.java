import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int r = in.nextInt();

		int max = 0;
		for (int i = l; i <= r; ++i){
			for (int j = i + 1; j <= r; ++j) max = Math.max(max, i ^ j);
		}
		System.out.println(max);
	}
}
