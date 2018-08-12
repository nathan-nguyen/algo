import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		while (q -- > 0) System.out.println(solve(in));
	}

	private long solve(Scanner in) {
		int n = in.nextInt();
		long m = in.nextLong();
		long[] arr = new long[n];
		for (int i = 0; i < n; ++i) arr[i] = in.nextInt();

		Map<Long, Integer> startMap = new HashMap<>();
		Map<Long, Integer> endMap = new HashMap<>();

		// [0, k] inclusive

		long result = 0;

		long sum = 0;
		for (int i = 0; i < n; ++i) {
			sum += arr[i];
			long key = (m - sum % m) % m;
			if (!startMap.containsKey(key)) {
				startMap.put(key, i);
				result = Math.max(result, sum % m);
			}
		}

		if (result == m - 1) return m - 1;

		for (int i = n-1; i >= 0; --i) {
			if (!endMap.containsKey(sum % m)) endMap.put(sum % m, i);
			sum -= arr[i];
		}

		List<Long> sl = new ArrayList<>(startMap.keySet());
		Collections.sort(sl);

		for (long key : endMap.keySet()) {
			int endIndex = endMap.get(key);

			long searchValue = m - 1 - key;
			int index = Collections.binarySearch(sl, searchValue);
			if (index >= 0 && startMap.get(sl.get(index)) <= endIndex) return m - 1;
			if (index < 0) index = -index - 1;

			for (int i = index - 1; i >= 0; --i) {
				long startKey = sl.get(i);
				int startIndex = startMap.get(startKey);

				if (startIndex <= endIndex) {
					result = Math.max(result, (key + startKey) % m);
					break;
				}
			}
		}
		return result;
	}
}
