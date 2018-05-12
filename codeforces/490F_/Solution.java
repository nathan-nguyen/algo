import java.util.Scanner;
import java.util.ArrayList;

public class Solution{
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	ArrayList<ArrayList<Integer>> con = new ArrayList<>();
	int[] r;
	int[][] dp;

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
//int n = 3000;

		r = new int[n];
		dp = new int[n][n];

		for (int i = 0; i < n; ++i) {
			con.add(new ArrayList<>());
			r[i] = in.nextInt();
//r[i] = i + 1;
		}

		for (int i = 0; i < n - 1; ++i){
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
//int x = i;
//int y = i + 1;
			con.get(x).add(y);
			con.get(y).add(x);	
		}

		for (int i = 0; i < n; ++i) traverseTree(i);

		int max = 1;	// City c to c
		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n; ++j) {
				System.out.println(i + " " + j + " " + dp[i][j]);
				max = Math.max(max,dp[i][j]);
			}
		}
		System.out.println(max);
	}

	private void traverseTree(int node){
		for (int i = 0; i < con.get(node).size(); ++i){
			int child = con.get(node).get(i);
			dfsTree(child, node, child, node);
		}
	}

	// Decrease sequence with max is node
	private void dfsTree(int par, int node, int root, int second){
		dp[par][node] = r[par] > r[node] ? 2 : 1;

		for (int i = 0; i < con.get(node).size(); ++i){
			int chd = con.get(node).get(i);
			if (chd == par) continue;
			
			dfsTree(node, chd, root, second);
			if (r[root] > r[node]) dp[root][second] = Math.max(dp[root][second], dp[node][chd] + 1);
		}
	}
}
