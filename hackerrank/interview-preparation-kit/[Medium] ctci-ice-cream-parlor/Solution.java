import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t -- > 0) {
			int m = in.nextInt();
			int n = in.nextInt();

			int[] c = new int[n];
			HashMap<Integer, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < n; ++i) {
				int key = in.nextInt();
				List<Integer> value = map.getOrDefault(key, new ArrayList<>());
				value.add(i + 1);
				map.put(key, value);
			}

			for (int key: map.keySet()) {
				if (key >= m) continue;

				List<Integer> value = map.get(m - key);
				if (key * 2 == m && value.size() > 1) {
					System.out.println(value.get(0) + " " + value.get(1));
					break;
				}
				if (value != null) {
					System.out.println(Math.min(map.get(key).get(0), value.get(0)) + " " + Math.max(map.get(key).get(0), value.get(0)));
					break;
				}
			}
		}
	}
}
