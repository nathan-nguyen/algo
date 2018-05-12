import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private ArrayList<Integer> vList = new ArrayList<>();
	private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	private boolean[] visited;

	private void solve(){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();

		visited = new boolean[n];

		for (int i = 0; i < n ; ++i) {
			vList.add(i);
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m ; ++i){
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int max = 0;
		for (int i = 0; i < n; ++i){
			if (!visited[i]) max = Math.max(max, dfs(i));
		}

		System.out.println(max);
	}

	private int dfs(int v){
		if (visited[v]) return 0;

		visited[v] = true;

		int result = 1;
		for (int n: graph.get(v)) result += dfs(n);

		return result;
	}
}
