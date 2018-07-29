import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int r = in.nextInt();

		long[] a = new long[n];
		HashMap<Long, Integer> count = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextLong();
			int freq = count.getOrDefault(a[i], 0) + 1;
			count.put(a[i], freq);
		}

		long total = 0;
		HashMap<Long, Integer> prev = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			int prevCount = prev.getOrDefault(a[i] , 0);
			prev.put(a[i], prevCount + 1);

			if (r == 1)  {
				total += (long) prevCount * (count.get(a[i]) - 1 - prevCount);
				continue;
			}
			if (a[i] % r != 0 || a[i] > Long.MAX_VALUE / r) continue;
			total += (long) prev.getOrDefault(a[i] / r, 0) * (count.getOrDefault(a[i] * r, 0) - prev.getOrDefault(a[i] * r, 0));
		}
		System.out.println(total);
		
	}
}
