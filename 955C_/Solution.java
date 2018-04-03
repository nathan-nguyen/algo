import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private ArrayList<Long> ls = new ArrayList<>();

	private void solve(){
		populateList();

		Scanner in = new Scanner(System.in);
		
		int Q = in.nextInt();

		while (Q -- > 0){
			long L = in.nextLong();
			long R = in.nextLong();

			int lp = Collections.binarySearch(ls, L);
			int rp = Collections.binarySearch(ls, R);
			lp = (lp < 0) ? -lp - 1 : lp - 1;
			rp = (rp < 0) ? -rp - 1 : rp + 1;

			long sl = (long) Math.sqrt(L);
			long sr = (long) Math.sqrt(R);
			sl = ((long) sl * sl == L) ? sl - 1 : sl;

			System.out.println(rp - lp + sr - sl);
		}
	}

	private void populateList(){
		ArrayList<Long> l = new ArrayList<>();

		for (int i = 2; i <= 1e6; ++i){
			for (long j = (long) i * i * i; j > 0 && j <= 1e18; j *= i) {
				long t = (long) Math.sqrt(j);
				if (t * t != j) l.add(j);
			}
		}
		Collections.sort(l);

		ls.add(l.get(0));
		for (int i = 1; i < l.size(); ++i){
			if (!l.get(i).equals(l.get(i-1))) ls.add(l.get(i));
		}
	}
}
