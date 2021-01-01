class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] visited = new boolean[rooms.size()];

		dfs(0, rooms, visited);

		boolean result = true;
		for (boolean b: visited) result = result && b;
		return result;
	}

	private void dfs(int r, List<List<Integer>> rooms, boolean[] visited){
		if (visited[r]) return;

		visited[r] = true;
		for (int n: rooms.get(r)) dfs(n, rooms, visited);
	}
}
