import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t-- > 0) {
			// 1 <= n <= 10^5
			int n = in.nextInt();
			int[] a = new int[n];

			for (int i = 0; i < n; ++i) a[i] = in.nextInt();
			System.out.println(maxSubArray(a) + " " + maxSubsequence(a));
		}
	}

	private int maxSubsequence(int[] a){
		int n = a.length;
		int max = Integer.MIN_VALUE;

		int sum = 0;
		for (int i = 0; i < n; ++i){
			if (a[i] > 0) sum += a[i];
			max = Math.max(max,a[i]);
		}
		return (sum > 0) ? sum : max;
	}

	private int maxSubArray(int[] a){
		int n = a.length;

		int sum = a[0];
		int max = a[0];

		for (int i = 1; i < n; ++i){
			if (sum + a[i] <= a[i]) sum = a[i];
			else sum += a[i];
			max = Math.max(max, sum);
		}
		return max;
	}
}

