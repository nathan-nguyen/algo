import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int b = in.nextInt();
		int s = in.nextInt();

		int[] a  = new int[n];
		for (int i = 0; i < n; ++i) a[i] = in.nextInt();

		int ux = in.nextInt();
		int uy = in.nextInt();

		int stop = 1;
		long curDistance = distance(a[stop], 0, ux, uy);

		for (int i = 2; i < n; ++i){
			long newDistance = distance(a[i], 0, ux, uy);
			int c = Double.compare(((double) a[i]) / b + Math.sqrt(newDistance) / s, ((double) a[stop]) / b + Math.sqrt(curDistance) / s);
			if (c < 0 || (c == 0 && newDistance < curDistance)) {
				stop = i;
				curDistance = newDistance;
			}
		}

		System.out.println(stop + 1);
	}

	private long distance(int x1, int y1, int x2, int y2){
		return (long)(x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}
