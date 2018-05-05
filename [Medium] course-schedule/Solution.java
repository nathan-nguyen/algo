class Solution {
	public boolean canFinish(int n, int[][] g) {
		boolean[] visited = new boolean[n];

		List<List<Integer>> l = new ArrayList<>();
		for (int i = 0; i < n; ++i) l.add(new ArrayList<>());

		for (int[] e: g) l.get(e[0]).add(e[1]);

		for (int i = 0; i < n; ++i){
			if (visited[i]) continue;
			if (hasCycle(i, visited, l, new HashSet<>())) return false;
		}
		return true;
	}

	private boolean hasCycle(int v, boolean[] visited, List<List<Integer>> l, Set<Integer> set){
		if (visited[v] && set.contains(v)) return true;
		if (visited[v]) return false;

		visited[v] = true;
		set.add(v);
		for (int c: l.get(v)){
			if (hasCycle(c, visited, l, set)) return true;
		}
		set.remove(v);
		return false;
	}
}
