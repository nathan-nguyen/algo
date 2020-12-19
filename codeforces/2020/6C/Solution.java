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

		if (n == 1) {
			System.out.println(1 + " " + 0);
			return;
		}

		int sum = 0;
		for (int i = 0; i < n; ++i){
			a[i] = in.nextInt();
			sum += a[i];
		}

		int local = 0;
		for (int i = 0; i < n; ++i){
			local += a[i];

			if (local * 2 == sum){
				System.out.println((i + 1) + " " + (n - i - 1));
				return;
			}
			if (local * 2 > sum){
				if (sum + a[i] >= 2 * local){
					System.out.println((i + 1) + " " + (n - i - 1));
				}
				else System.out.println(i + " " + (n - i));
				return;
			}
		}
	}
}
