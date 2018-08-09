import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t -- > 0) {
			int n = in.nextInt();
			int d = in.nextInt() % n;

			int[] arr = new int[n];
			boolean[] visited = new boolean[d];

			for (int i = 0; i < n; ++i) arr[i] = in.nextInt();
			
			for (int i = 0; i < d; ++i) {
				if (visited[i]) continue;

				visited[i] = true;

				int cur = i;
				int next = (i + n - d) % n;
				while (next != cur) {
					arr[cur] ^= arr[next];
					arr[next] ^= arr[cur];
					arr[cur] ^= arr[next];

					if (next < d) visited[next] = true;
					next = (next + n - d) % n;
				}
			}

			for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
}
