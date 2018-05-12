import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T-- > 0) {
			int n = in.nextInt();
			int[] a = new int[n];
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < n; ++i){
				a[i] = in.nextInt();
				min = Math.min(min, a[i]);
			}

			long result = 0;
			for (int i = 0; i < n; ++i){
				int diff = a[i] - min;
				result += (diff / 5 + (diff % 5) / 3 + (diff % 5) % 3);
			}
			System.out.println(result);
		}
	}
}
