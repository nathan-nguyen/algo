import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private class V{
		int val;
		boolean isVisited;

		int[] dp = new int[26];
		HashSet<V> toV = new HashSet<>();

		public V(int val){
			this.val = val;
		}
	}

	private ArrayList<V> vList = new ArrayList<>();
	private HashSet<V> stack = new HashSet<>();

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		String s = in.next();
		for (int i = 0; i < n; ++i) vList.add(new V(s.charAt(i) - 'a'));

		while (m-- > 0){
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			vList.get(x).toV.add(vList.get(y));
		}

		for (V v: vList){
			if (!v.isVisited){
				if (dfs(v)) {
					System.out.println(-1);
					return;
				}
			}
		}

		int max = 0;
		for (V v: vList){
			for (int i = 0; i < 26; ++i) max = Math.max(max, v.dp[i]);
		}
		System.out.println(max);
	}

	private boolean dfs(V v){
		if (v.isVisited) return stack.contains(v);

		v.isVisited = true;
		v.dp[v.val] = 1;
		stack.add(v);

		for (V to: v.toV){
			if (dfs(to)) return true;

			for (int i = 0; i < 26; ++i){
				if (v.val == i) v.dp[i] = Math.max(v.dp[i], to.dp[i] + 1);
				else v.dp[i] = Math.max(v.dp[i], to.dp[i]);
			}
		}
		stack.remove(v);
		return false;
	}
}
