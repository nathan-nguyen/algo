import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] a = new int[n];
		int[] pos = new int[n];

		for (int i = 0; i < n; ++i) {
			int val = in.nextInt() - 1;
			a[i] = val;
			pos[val] = i;
		}

		for (int i = 0; i < n; ++i) a[pos[in.nextInt() - 1]] = i;

		for (int i = 1; i < n; ++i){
			if (a[i] < a[i-1]) {
				System.out.println(n - i);
				return;
			}
		}
		System.out.println(0);
	}
}
