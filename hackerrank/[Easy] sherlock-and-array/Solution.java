import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T-- > 0){
			int n = in.nextInt();
			int[] a = new int[n];

			int sum = 0;
			for (int i = 0; i < n; ++i) {
				a[i] = in.nextInt();
				sum += a[i];
			}

			System.out.println(checkArray(a, sum) ? "YES" : "NO");
		}
	}

	private boolean checkArray(int[] a, int sum){
		int n = a.length;
	
		int prefixSum = 0;
		for (int i = 0; i < n; ++i){
                	if (prefixSum + prefixSum + a[i] == sum) return true;
			prefixSum += a[i];
                }
		return false;	
	}
}
