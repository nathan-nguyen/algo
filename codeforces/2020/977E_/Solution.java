import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private ArrayList<ArrayList<Integer>> g = new ArrayList<>();
	private boolean[] visited;

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		for (int i = 0; i < n; ++i) g.add(new ArrayList<>());

		for (int i = 0; i < m; ++i){
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;

			g.get(a).add(b);
			g.get(b).add(a);
		}

		visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; ++i){
			if (visited[i]) continue;
			if (dfs(i)) ++count;
		}

		System.out.println(count);
	}

	private boolean dfs(int v){
		if (visited[v]) return true;

		visited[v] = true;
		boolean result = true;
		for (int n: g.get(v)) result = result && dfs(n);
		return (g.get(v).size() == 2 && result);
	}
}
