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

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			int val = in.nextInt();
			int frq = map.getOrDefault(val, 0);
			map.put(val, frq + 1);
		}

		int total = 0;
		for (int key: map.keySet()) total += removeCount(key, map);

		System.out.println(total);
	}

	private int removeCount(int key, HashMap<Integer, Integer> map) {
		for (int i = 0; i < 31; ++i) {
			int k = 1 << i;
			if (key * 2 == k && map.get(key) == 1) continue;
			if (map.containsKey(k - key)) return 0;
		}
		return map.get(key);
	}
}
