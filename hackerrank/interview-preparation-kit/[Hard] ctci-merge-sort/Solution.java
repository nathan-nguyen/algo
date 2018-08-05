import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution ();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		while (q -- > 0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) arr[i] = in.nextInt();

			int[] ftree = new int[10_000_002];
			long count = 0;
			for (int i = n - 1; i >= 0; --i) {
				count += get(arr[i] - 1, ftree);
				update(arr[i], ftree);
			}
			System.out.println(count);
		}
	}

	private int get(int index, int[] ftree) {
		++index;
		int count = 0;
		while (index > 0) {
			count += ftree[index];
			index -= (index & -index);
		}
		return count;
	}

	private void update(int index, int[] ftree) {
		++index;
		while (index <= ftree.length) {
			++ftree[index];
			index += (index & -index);
		}
	}
}
