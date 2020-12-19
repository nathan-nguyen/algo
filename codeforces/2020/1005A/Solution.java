import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> sc = new ArrayList<>();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = in.nextInt();
			if (arr[i] == 1 && i > 0) sc.add(arr[i - 1]);
		}
		sc.add(arr[n - 1]);

		System.out.println(sc.size());
		for (int i: sc) System.out.print(i + " ");
		System.out.println();
	}
}
