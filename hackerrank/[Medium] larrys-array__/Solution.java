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
			int[] a = new int[n];
			for (int i = 0; i < n; ++i) a[i] = in.nextInt();

			System.out.println(solve(n, a) ? "YES" : "NO");
		}
	}

	private boolean solve(int n, int[] a){
		int[] pos = new int[n+1];

		if (n <= 1) return true;

		for (int i = 0; i < n; ++i) pos[a[i]] = i;

		for (int i = 0; i < n - 2; ++i){
			while (a[i] != i + 1){
				int k = pos[i+1];
				if (k == i + 1){
					int C = a[k-1];
					int A = a[k];
					int B = a[k+1];
					a[k-1] = A;	pos[A] = k - 1;
					a[k] = B;	pos[B] = k;
					a[k+1] = C;	pos[C] = k + 1;
				}
				else {
					int B = a[k-2];
					int C = a[k-1];
					int A = a[k];
					a[k-2] = A;	pos[A] = k - 2;
					a[k-1] = B;	pos[B] = k - 1;
					a[k] = C;	pos[C] = k;
				}
			}
		}
		return a[n-2] == n - 1 && a[n-1] == n;
	}
}
