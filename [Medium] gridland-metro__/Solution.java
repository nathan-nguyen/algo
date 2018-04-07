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
		int m = in.nextInt();
		int k = in.nextInt();

		if (k == 0) {
			System.out.println((long)n * m);
			return;
		}

		int[][] t = new int[k][3];
		for (int i = 0; i < k; ++i){
			t[i][0] = in.nextInt() - 1;
			t[i][1] = in.nextInt() - 1;
			t[i][2] = in.nextInt() - 1;
		}

		Arrays.sort(t, new Comparator<int[]>(){
			@Override public int compare(int[] o1, int[] o2){
				if (o1[0] != o2[0]) return Float.compare(o1[0], o2[0]);
				else if (o1[1] != o2[1]) return Float.compare(o1[1], o2[1]);
				return Float.compare(o1[2], o2[2]);
			}
		});

		long total = 0;
		int r = t[0][0];
		int c1 = t[0][1];
		int c2 = t[0][2];
		for (int i = 1; i < k; ++i){
			if(t[i][0] != r || t[i][1] > c2){
				total += (c2 - c1 + 1);
				r = t[i][0];
				c1 = t[i][1];
				c2 = t[i][2];
			}
			else c2 = Math.max(c2, t[i][2]);
			
		}
		total += (c2 - c1 + 1);

		System.out.println((long) n * m - total);
	}
}
