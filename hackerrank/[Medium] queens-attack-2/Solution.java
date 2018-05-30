import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();

		int qx = in.nextInt() - 1;
		int qy = in.nextInt() - 1;

		int[][] a = new int[k][2];
		for (int i = 0; i < k; ++i){
			a[i][0] = in.nextInt() - 1;
			a[i][1] = in.nextInt() - 1;
		}

		int up = qy;
		int down = n - 1 - qy;
		int left = qx;
		int right = n - 1 - qx;
		int topLeft = Math.min(qx, qy);
		int topRight = Math.min(n - 1 - qx, qy);
		int downLeft = Math.min(qx, n - 1 - qy);
		int downRight = Math.min(n - 1 - qx, n - 1 - qy);

		int sum = 0;

		for (int[] b: a){
			if (b[0] == qx && b[1] < qy) up    = Math.min(up,    qy - b[1] - 1);
			if (b[0] == qx && b[1] > qy) down  = Math.min(down,  b[1] - qy - 1);
			if (b[1] == qy && b[0] < qx) left  = Math.min(left,  qx - b[0] - 1);
			if (b[1] == qy && b[0] > qx) right = Math.min(right, b[0] - qx - 1);
			if (b[0]  < qx && b[1] < qy && qx - b[0] == qy - b[1]) topLeft   = Math.min(topLeft,   qx - b[0] - 1);
			if (b[0]  < qx && b[1] > qy && qx - b[0] == b[1] - qy) downLeft  = Math.min(downLeft,  qx - b[0] - 1);
			if (b[0]  > qx && b[1] < qy && b[0] - qx == qy - b[1]) topRight  = Math.min(topRight,  b[0] - qx - 1);
			if (b[0]  > qx && b[1] > qy && b[0] - qx == b[1] - qy) downRight = Math.min(downRight, b[0] - qx - 1);
		}

		sum = up + down + left + right + topLeft + topRight + downLeft + downRight;
		System.out.println(sum);
	}
}
