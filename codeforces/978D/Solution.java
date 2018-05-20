import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] b = new int[n];
		
		for (int i = 0; i < n; ++i) b[i] = in.nextInt();

		if (n <= 2) {
			System.out.println(0);
			return;
		}

		int min = Integer.MAX_VALUE;


		for (int i = -1; i < 2; ++i){
			for (int j = -1; j < 2; ++j){
				int k = checkArray(n, b, i, j);
				if (k != -1) min = Math.min(min, k + Math.abs(i) + Math.abs(j));
			}
		}

		if (min == Integer.MAX_VALUE) min = -1;
	
		System.out.println(min);
	}

	private int checkArray(int n, int[] b, int x, int y){
		int result = 0;

		int[] nb = new int[n];
		System.arraycopy(b, 0, nb, 0, n);

		nb[0] += x;
		nb[1] += y;

		int d = nb[1] - nb[0];
                for (int i = 2; i < n; ++i){
                        nb[i] = nb[i - 1] + d;
                        int k = Math.abs(nb[i] - b[i]);

                        if (k > 1) return -1;
			result += k;
                }
		return result;
	}
}
