import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	private static int MAX = 1000000001;

	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	public class Edge{
		V from;
		V to;
		int time;

		public Edge(V from, V to, int time){
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}

	public class V{
		int index;
		boolean isVisited;
		ArrayList<Edge> toEList = new ArrayList<>();
		
		int[] dp;
		V[] lastV;
		
		public V(int index, int n){
			this.index = index;

			dp = new int[n+1];
			for (int i = 0; i <= n; ++i) dp[i] = MAX;

			lastV = new V[n+1];
		}
	}

	ArrayList<V> vList = new ArrayList<>();
	private int n;

	private void solve(){
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		int m = in.nextInt();
		int T = in.nextInt();

		for (int i = 0; i < n; ++i) vList.add(new V(i, n));

		while (m-- > 0){
			int from = in.nextInt() - 1;
			int to = in.nextInt() - 1;
			int time = in.nextInt();
			vList.get(from).toEList.add(new Edge(vList.get(from), vList.get(to), time));
		}
		
		V finalV = vList.get(0);
		dfs(finalV);
		for (int i = n; i >=1; --i){
			if (finalV.dp[i] <= T){
				System.out.println(i);
				StringBuilder path = new StringBuilder();
				while (finalV != null){
					path.append(finalV.index + 1);
					path.append(" ");
					finalV = finalV.lastV[i--];
				}
				System.out.println(path);
				return;
			}
		}
	}

	private void dfs(V v){
		if (v.isVisited) return;
		
		v.isVisited = true;

		if (v.index == n - 1){
			v.dp[1] = 0;	// Check until index = 1 then stop;
			return;
		}

		for (Edge e: v.toEList){
			V to = e.to;
			dfs(to);
			for (int i = n; i >= 2; --i){
				if (to.dp[i-1] + e.time < v.dp[i]){
					v.dp[i] = to.dp[i-1] + e.time;
					v.lastV[i] = to;
				}
			}
		}
	}
}
