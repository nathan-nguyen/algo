import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	private boolean[] visited;

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		visited = new boolean[n];

		for (int i = 0; i < n; ++i) tree.add(new ArrayList<>());

		int m = in.nextInt();

		for (int i = 0; i < m; ++i){
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			tree.get(a).add(b);
			tree.get(b).add(a);
		}

		System.out.println(dfs(0)[0]);
	}

	private int[] dfs(int v){
		visited[v] = true;

		int[] val = new int[2];
		val[1] = 1;

		for (int n: tree.get(v)){
			if (visited[n]) continue;
			int[] result = dfs(n);

			val[0] += result[0];
			val[1] += result[1];

			if (result[1] % 2 == 0) ++val[0];
		}
		return val;
	}
}
