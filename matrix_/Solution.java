import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	int[] id;
	boolean[] robot;
	int[] sz;
	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		id = new int[n];
		sz = new int[n];
		robot = new boolean[n];

		for (int i = 0; i < n; ++i){
			id[i] = i;
			sz[i] = 1;
		}

		int[][] r = new int[n-1][3];
		for (int i = 0; i < n - 1; ++i){
			r[i][0] = in.nextInt();
			r[i][1] = in.nextInt();
			r[i][2] = in.nextInt();
		}

		Arrays.sort(r, new Comparator<int[]>(){
			@Override public int compare(int[] o1, int[] o2){
				return Double.compare(o1[2], o2[2]);
			}
		});

		for (int i = 0; i < k; ++i) robot[in.nextInt()] = true;

		long total = 0;
		for (int i = 0; i < n - 1; ++i) total += buildRoad(r[i][0], r[i][1], r[i][2]);

		System.out.println(total);
	}

	private int buildRoad(int l, int r, int w){
		boolean add = robot[l] || robot[r];

		while (l != id[l]) l = id[l];
		while (r != id[r]) r = id[r];

		if (l == r) return 0;

		if (sz[l] <= sz[r]) {
			id[l] = r;
			sz[r] += sz[l];
		}
		else {
			id[r] = l;
			sz[l] += sz[r];
		}
		
		if (add) {
			robot[l] = false;
			robot[r] = false;
			return w;
		}
		return 0;
	}
}
