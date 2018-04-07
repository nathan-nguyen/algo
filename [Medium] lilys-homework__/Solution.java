import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		// Distinct integers
		int[][] a = new int[n][2];
		for (int i = 0; i < n; ++i){
			a[i][0] = in.nextInt();
			a[i][1] = i;
		}

		Arrays.sort(a, new Comparator<int[]>(){
			@Override public int compare(int[] o1, int[] o2){
				if (o1[0] == o2[0]) return 0;
				return (o1[0] > o2[0]) ? 1 : -1;
			}
		});

		int[] p = new int[n];
		// p[old_position] -> new_position
		for (int i = 0; i < n; ++i) p[a[i][1]] = i;

		boolean[] cycle = new boolean[n];

		int inc = 0;
		for (int i = 0; i < n; ++i){
			if (!cycle[i]) inc += cycleSearch(cycle, i, p);
		}

		for (int i = 0; i < n; ++i) {
			p[i] = n - 1 - p[i];
			cycle[i] = false;
		}

		int desc = 0;
		for (int i = 0; i < n; ++i){
			if (!cycle[i]) desc += cycleSearch(cycle, i, p);
		}

		System.out.println(Math.min(inc, desc));
	}

	private int cycleSearch(boolean[] cycle, int i, int[] p){
		if (i == p[i] || cycle[i]) return 0;
		cycle[i] = true;

		return cycle[p[i]] ? 0 : 1 + cycleSearch(cycle, p[i], p);
	}
}
