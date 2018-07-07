import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; ++i) a[i] = in.nextInt() - 1;

		int count = 0;
		for (int i = 0; i < n; ++i){
			while (a[i] != i) {
				int swap = a[i];
				a[i] ^= a[swap];
				a[swap] ^= a[i];
				a[i] ^= a[swap];
				++count;
			}
		}

		System.out.println(count);

		in.close();
	}
}
