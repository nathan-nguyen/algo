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
			int n = in.nextInt();
			
			int total = 0;
			int min = Integer.MAX_VALUE;

			int[] a = new int[n];

			for (int i = 0; i < n; ++i){
				a[i] = in.nextInt();
				min = Math.min(min, a[i]);
			}

			int count = 0;
			for (int i = 0; i < n; ++i){
				int diff = a[i] - min;
				count += diff / 5;
				diff = diff % 5;
				count += diff / 2;
				count += diff % 2;
			}
			System.out.println(count);
		}
			
	}
}
