import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int w = in.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; ++i) a[i] = in.nextInt();

		int max = a[0];
		int min = a[0];
		int sum = a[0];
		for (int i = 1; i < n; ++i){
			sum += a[i];
			min = Math.min(min, sum);
			max = Math.max(max, sum);
		}

		if (max > w) {
			System.out.println(0);
			return;
		}

		int result = w - (max > 0 ? max : 0) + ((min < 0) ? min : 0) + 1;
		if (result < 0 || result > w + 1) result = 0;

		System.out.println(result);
	}
}
