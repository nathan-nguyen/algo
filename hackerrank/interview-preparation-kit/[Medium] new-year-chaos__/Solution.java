import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t -- > 0) {
			int n = in.nextInt();
			int[] a = new int[n];

			for (int i = 0; i < n; ++i) a[i] = in.nextInt() - 1;

			int result = solve(n, a);
			System.out.println(result == -1 ? "Too chaotic" : result);
		}
	}

	private int solve(int n, int[] a) {
		int[] tree = new int[n+1];
	
		int total = 0;
		for (int k: a){
			int result = k - get(tree, k);
			if (result > 2) return -1;
			total += result;
			add(tree, k);
		}
		return total;	
	}

	private int get(int[] tree, int index) {
		++index;
		int value = 0;

		while (index > 0) {
			value += tree[index];
			index -= index & (-index);
		}
		return value;
	}

	private void add(int[] tree, int index) {
		++index;

		while (index < tree.length){
			++tree[index];
			index += index & (-index);
		}
	}
}
