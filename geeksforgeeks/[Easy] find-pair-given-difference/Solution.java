import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
                int t = in.nextInt();

                while (t -- > 0) {
                        int l = in.nextInt();
			int n = in.nextInt();

                        Set<Integer> set = new HashSet<>();
                        while (l -- > 0) set.add(in.nextInt());
			System.out.println(check(set, n) ? 1 : -1);
                }
	}

	private boolean check(Set<Integer> set, int k) {
		for (int e: set) {
			if (set.contains(e + k) || set.contains(e - k)) return true;
		}
		return false;
	}
}
