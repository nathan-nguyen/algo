import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int al = in.nextInt();
		int bl = in.nextInt();
		int cl = in.nextInt();

		HashSet<Integer> set = new HashSet<>();

		set.clear();
		while (al -- > 0) set.add(in.nextInt());
		List<Integer> la = new ArrayList<>(set);
		Collections.sort(la);

		set.clear();
		while (bl -- > 0) set.add(in.nextInt());
		List<Integer> lb = new ArrayList<>(set);
		Collections.sort(lb);

		set.clear();
		while (cl -- > 0) set.add(in.nextInt());
		List<Integer> lc = new ArrayList<>(set);
		Collections.sort(lc);

		long total = 0;
		for (int k: lb) {
			int ai = Collections.binarySearch(la, k);
			ai = ai < 0 ? -ai - 1 : ai + 1;

			int ci = Collections.binarySearch(lc, k);
			ci = ci < 0 ? -ci - 1 : ci + 1;

			total += (long) ai * ci;
		}
		System.out.println(total);
	}

}
