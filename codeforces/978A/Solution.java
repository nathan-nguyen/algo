import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] a = new int[n];
		boolean[] h = new boolean[1001];

		for (int i = 0; i < n ; ++i) a[i] = in.nextInt();

		ArrayList<Integer> l = new ArrayList<>();

		for (int i = n - 1; i >= 0; --i){
			if (h[a[i]]) continue;
			h[a[i]] = true;
			l.add(0, a[i]);
		}

		System.out.println(l.size());
		for (int e: l) System.out.print(e + " ");
		System.out.println();
	}
}
