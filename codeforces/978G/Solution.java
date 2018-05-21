import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		if (!solution.solve()) System.out.println(-1);
	}

	private boolean solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		int[][] s = new int[m][4];

		for (int i = 0; i < m; ++i){
			s[i][0] = in.nextInt() - 1;
			s[i][1] = in.nextInt() - 1;
			s[i][2] = in.nextInt();
			s[i][3] = i + 1;
		}

		Arrays.sort(s, new Comparator<int[]>(){
			@Override public int compare(int[] o1, int[] o2){
				if (o1[1] == o2[1]) return 0;
				return (o1[1] > o2[1]) ? 1 : -1;
			}
		});

		int[] d = new int[n];

		for (int[] sc: s){
			if (sc[1] > n) return false;

			for (int j = sc[0]; sc[2] > 0; ++j){
				if (j >= n) return false;

				if (d[j] != 0) continue;
				d[j] = sc[3];
				--sc[2];
			} 

			if (d[sc[1]] != 0) return false;
			d[sc[1]] = m + 1;
		}

		for (int i = 0; i < n; ++i) System.out.print(d[i] + " ");
		System.out.println();

		return true;
	}
}
