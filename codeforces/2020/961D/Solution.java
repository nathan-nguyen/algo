import java.util.Scanner;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.solve() ? "YES" : "NO");
	}

	private class Line {
		long a, b, c;
		// ax + by = c
		public Line(long[] p1, long[] p2){
			a = p2[1] - p1[1];
			b = p1[0] - p2[0];
			c = p1[0] * p2[1] - p2[0] * p1[1];
		}

		public boolean has(long[] p){
			return a * p[0] + b * p[1] == c;
		}
	}

	long[][] p;
	long[] p1, p2, p3, p4;
	ArrayList<Integer> l1 = new ArrayList<>();
	ArrayList<Integer> l2 = new ArrayList<>();
	ArrayList<Integer> l3 = new ArrayList<>();

	// All n points are distinct - 1 <= n <= 10^5
	private boolean solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		p = new long[n][2];

		for (int i = 0; i < n; ++i) {
			p[i][0] = in.nextLong();
			p[i][1] = in.nextLong();
		}

		if (n < 4) return true;

		p1 = p[0];
		p2 = p[1];

		Line fl = new Line(p1, p2);
		Line sl = null;
		Line tl = null;

		for (int i = 2; i < n; ++i){
			if (!fl.has(p[i])) {
				p3 = p[i];
				sl = new Line(p1, p3);
				tl = new Line(p2, p3);
				break;
			}
			// All points are in the same line
			if (i == n - 1) return true;
		}

		for (int i = 0; i < n; ++i){
			boolean c1 = fl.has(p[i]);
			boolean c2 = sl.has(p[i]);
			boolean c3 = tl.has(p[i]);

			if (c1) l1.add(i);
			if (c2) l2.add(i);
			if (c3) l3.add(i);

			if (!(c1 || c2 || c3)) {
				p4 = p[i];
				Line nl = new Line(p3, p4);
				for (int j = 0; j < n; ++j){
					if (!(fl.has(p[j]) || nl.has(p[j]))) break;
					if (j == n - 1) return true;
				}

				fl = new Line(p1, p3);
				nl = new Line(p2, p4);
				for (int j = 0; j < n; ++j){
                                        if (!(fl.has(p[j]) || nl.has(p[j]))) break;
                                        if (j == n - 1) return true;
                                }

				fl = new Line(p1, p4);
				nl = new Line(p2, p3);
				for (int j = 0; j < n; ++j){
                                        if (!(fl.has(p[j]) || nl.has(p[j]))) break;
                                        if (j == n - 1) return true;
                                }
				return false;
			}
		}	

		for (int i = 0; i < l1.size(); ++i){
			int index = l1.get(i);
			if (!(sl.has(p[index]) || tl.has(p[index]))) break;
			if (index == l1.size() - 1) return true;
		}

		for (int i = 0; i < l2.size(); ++i){
                        int index = l2.get(i);
                        if (!(fl.has(p[index]) || tl.has(p[index]))) break;
			if (index == l2.size() - 1) return true;
                }

		for (int i = 0; i < l3.size(); ++i){
                        int index = l3.get(i);
                        if (!(fl.has(p[index]) || sl.has(p[index]))) break;
			if (index == l3.size() - 1) return true;
                }

		return false;
	}
}
