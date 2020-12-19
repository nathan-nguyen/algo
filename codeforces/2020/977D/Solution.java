import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		HashSet<Long> set = new HashSet<>();
		long start = in.nextLong();
		set.add(start);

		ArrayList<Long> l = new ArrayList<>();

		for (int i = 1; i < n; ++i) set.add(in.nextLong());

		long next = start;
		l.add(next);
		while (set.contains(next * 2) || (next % 3 == 0 && set.contains(next / 3))){
			if (set.contains(next * 2)) {
				next = next * 2;
				l.add(next);
			}
			else {
				next = next / 3;
				l.add(next);
			}
		}

		next = start;
		while (set.contains(next * 3) || (next % 2 == 0 && set.contains(next / 2))){
			if (set.contains(next * 3)) {
				next = next * 3;
				l.add(0, next);
			}
			else {
				next = next / 2;
				l.add(0, next);
			}
		}

		for (long e: l) System.out.print(e + " ");
		System.out.println();
	}
}
