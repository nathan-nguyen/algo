import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int d = in.nextInt();
		int h = in.nextInt();

		int min = 0;
		int max = 0;

		int[][] a = new int[d][2];
		for (int i = 0; i < d; ++i){
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt();
			
			min += a[i][0];
			max += a[i][1];
		}
		
		if (h < min || h > max) {
			System.out.println("NO");
			return;
		}
		System.out.println("YES");
		int left = h - min;

		for (int i = 0; i < d; ++i){
			int k = Math.min(a[i][0] + left, a[i][1]);
			left -= (k - a[i][0]);
			System.out.print(k + " ");
		}
		System.out.println();
	}
}
