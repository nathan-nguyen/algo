import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Long k = in.nextLong();

		Map<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			Long val = in.nextLong();
			int frq = map.getOrDefault(val, 0);
			map.put(val, frq + 1);
		}

		long total = 0;
		for (long key: map.keySet()) {
			int v = map.getOrDefault(key + k, 0);
			total += (long) map.get(key) * v;
		}
		System.out.println(total);
	}
}
