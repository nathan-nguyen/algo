import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();

		int[] arr = new int[n+1];
		while (m -- > 0){
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			int k = in.nextInt();
			arr[a] += k;
			arr[b+1] -= k;
		}

		long max = 0;
		long total = 0;
		for (int i = 0; i < n; ++i) {
			total += arr[i];
			max = Math.max(max, total);
		}
		System.out.println(max);
	}
}
