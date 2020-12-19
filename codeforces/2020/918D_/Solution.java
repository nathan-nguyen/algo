import java.util.Scanner;
import java.util.ArrayList;

public class Solution{
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private class Edge{
		int val;
		int toV;
		public Edge(int val, int toV){
			this.val = val;
			this.toV = toV;
		}
	}

	ArrayList<ArrayList<Edge>> vList = new ArrayList<>();
	int n;
	int m;
	boolean[] visited;
	int[][] dp;

	private void solve(){
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();

		visited = new boolean[n];
		dp = new int[n][m+1];
		
		for (int i = 0; i < n; ++i) vList.add(new ArrayList<>());

		for (int i = 0; i < m; ++i){
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			int val = in.next().charAt(0) - 'a' + 1;
			vList.get(x).add(new Edge(val, y));
		}

		for (int i = 0; i < n; ++i){
			if (!visited[i]){
				dfs(i);
			}
		}

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < n; ++j){
				if (isMaxWin(i, j)) System.out.print("A");
				else System.out.print("B");
			}
			System.out.println();
		}

		for (int i = 0; i < n; ++i){
			for (int j = 1; j < m+1; ++j){
				if (dp[i][j] < 10) System.out.print(" " + dp[i][j]);
				else System.out.print(dp[i][j]);
			}
			System.out.println();
		}
	}

	private void dfs(int v){
		if (visited[v]) return;
		
		visited[v] = true;

		for (Edge e: vList.get(v)){
			dfs(e.toV);
			dp[v][1] = Math.max(dp[v][1], e.val);
			for (int i = 2; i <= m; ++i) dp[v][i] = Math.max(dp[v][i], dp[e.toV][i-1]);
		}
	}

	private boolean isMaxWin(int i, int j){
		if (i == j) return false;
		for (int k = 1; k <= m; ++k){
			if (dp[i][k] < dp[j][k-1]) return false;
			if (dp[i][k] > dp[j][k]) return true;
		}
		return false;
	}
}
