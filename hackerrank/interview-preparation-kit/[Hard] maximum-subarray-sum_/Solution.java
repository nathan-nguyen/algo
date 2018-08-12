import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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

		Set<Long> startSet = new HashSet<>();
		Set<Long> endSet = new HashSet<>();

		// Unique prefix sum with minimum and maximum index (startList - minimum index, endList - maximum index)
		List<long[]> startList = new ArrayList<>();
		List<long[]> endList = new ArrayList<>();

		long result = 0;

		long sum = 0;
		for (int i = 0; i < n; ++i) {
			sum += arr[i];
			long key = (m - sum % m) % m;
			if (!startSet.contains(key)) {
				startList.add(new long[] {i, key});
				startSet.add(key);
				result = Math.max(result, sum % m);
			}
		}

		if (result == m - 1) return m - 1;

		for (int i = n-1; i >= 0; --i) {
			long key = sum % m;
			if (!endSet.contains(key)) {
				endSet.add(key);
				endList.add(new long[] {i, sum % m});
			}
			sum -= arr[i];
		}

		TreeSet<long[]> sl = new TreeSet<>((u, v) -> u[1] == v[1] ? Long.compare(u[0], v[0]) : Long.compare(u[1], v[1]));
		int startListIndex = 0;

		for (int i = endList.size() - 1; i >= 0; --i) {
			long[] key = endList.get(i);
			while (startListIndex < startList.size() && startList.get(startListIndex)[0] <= key[0]) {
				sl.add(startList.get(startListIndex++));
			}

			long searchValue = m - 1 - key[1];

			// Strictly smaller
			long[] searchResult = sl.lower(new long[] {Long.MAX_VALUE, m - 1 - key[1]});
			if (searchResult == null) continue;
				
			result = Math.max(result, (key[1] + searchResult[1]) % m);
		}
		return result;
	}

}
