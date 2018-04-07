import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int d = in.nextInt();

		int[] a = new int[n];

		for (int i = 0; i < n; ++i) a[i] = in.nextInt();

		if (d == n) {
			System.out.println(0);
			return;
		}

		ArrayList<Integer> l = new ArrayList<>();

		for (int i = 0; i < d; ++i) l.add(a[i]);

		Collections.sort(l);

		int count = 0;

		for (int i = d; i < n; ++i){
			if (d % 2 == 0) count += (a[i] >= l.get(d / 2 - 1) + l.get(d / 2) ? 1 : 0);
			else count += (a[i] >= 2 * l.get(d / 2) ? 1 : 0);

			l.remove(Collections.binarySearch(l, a[i-d]));
			int pos = Collections.binarySearch(l, a[i]);
			pos = pos < 0 ? -pos - 1 : pos;
			l.add(pos, a[i]);
		}

		System.out.println(count);
	}
}
