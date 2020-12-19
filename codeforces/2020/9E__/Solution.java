import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		// Union Find Algorithm
		int[] pr = new int[n];
		int[] sz = new int[n];
		int[] dg = new int[n];

		for (int i = 0; i < n; ++i) {
			pr[i] = i;
			sz[i] = 1;
		}

		for (int i = 0; i < m; ++i) {
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;

			// Degree each node must < 2 and Graph might contains loop, if a, b is already connected and i != m - 1
			if (dg[a] == 2 || dg[b] == 2 || isConnected(a, b, pr) && i != n - 1) {
				System.out.println("NO");
				return;
			}

			connect(a, b, dg, pr, sz);
		}

		Queue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < n; ++i) {
			if (dg[i] < 2) queue.offer(i);
		}

		System.out.println("YES");

		int count = 0;
		StringBuilder sb = new StringBuilder();

		while (queue.size() > 0) {
			int a = queue.poll();
			int b = -1;

			if (queue.size() == 0) b = a;
			else if (dg[a] == 0) b = queue.poll();
			else {
				List<Integer> l = new ArrayList<>();
				b = queue.poll();
				while (isConnected(a, b, pr) && queue.size() > 0) {
					l.add(b);
					b = queue.poll();
				}
				queue.addAll(l);
			}
			connect(a, b, dg, pr, sz);
			++count;
			sb.append((a+1) + " " + (b+1) + "\n");
			if (dg[a] < 2) queue.offer(a);
			if (dg[b] < 2) queue.offer(b);
		}

		System.out.println(count);
		System.out.println(sb);
	}

	private boolean isConnected(int a, int b, int[] pr) {
		while (a != pr[a]) a = pr[a];
		while (b != pr[b]) b = pr[b];
		return a == b;
	}

	private void connect(int a, int b, int[] dg, int[] pr, int[] sz) {
		++dg[a];
		++dg[b];

		while (a != pr[a]) a = pr[a];
		while (b != pr[b]) b = pr[b];
		if (sz[a] >= sz[b]) {
			pr[b] = a;
			sz[a] += sz[b];
		} else {
			pr[a] = b;
			sz[b] += sz[a];
		}
	}
}
