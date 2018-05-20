import java.util.Scanner;
import java.util.Arrays;

public class Solution{
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();

		int[] s = new int[n];
		int[] so = new int[n];

		for (int i = 0; i< n; ++i) {
			s[i] = in.nextInt();
			so[i] = s[i];
		}

		int[][] a = new int[k][2];

		int[] r = new int[n];

		for (int i = 0; i < k; ++i){
			int o = in.nextInt() - 1;
			int t = in.nextInt() - 1;

			if (s[o] > s[t]) --r[o];
			else if (s[t] > s[o]) --r[t];
		}

		Arrays.sort(so);

		for (int i = 0; i < n; ++i) r[i] += searchInsert(so, s[i]);

		for (int i = 0; i < n; ++i) System.out.print(Math.max(0, r[i]) + " ");
		System.out.println();
	}

	public int searchInsert(int[] A, int target) {
		int low = 0, high = A.length-1;
		while(low < high){
			int mid = (low+high) / 2;
			if(A[mid] == target) high = mid;
			else if(A[mid] > target) high = mid-1;
			else low = mid+1;
		}
		return low;
	}
}
