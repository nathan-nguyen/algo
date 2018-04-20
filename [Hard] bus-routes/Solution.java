class Solution {
	public int numBusesToDestination(int[][] routes, int S, int T) {
		if (S == T) return 0;

		for (int i = 0; i < routes.length; ++i){
			Arrays.sort(routes[i]);
		}

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < routes.length; ++i) graph.add(new ArrayList<>());

		for (int i = 0; i < routes.length; ++i){
			for (int j = i + 1; j < routes.length; ++j){
				if (isConnect(routes[i], routes[j])) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
		}

		HashSet<Integer> set = new HashSet<>();
		boolean[] visited = new boolean[routes.length];

		for (int i = 0; i < routes.length; ++i){
			if (Arrays.binarySearch(routes[i], S) < 0) continue;
			set.add(i);
			visited[i] = true;
			if (Arrays.binarySearch(routes[i], T) >= 0) return 1;
		}
		
		int count = 1;
		while (set.size() > 0){
			++count;
			HashSet<Integer> newSet = new HashSet<>();
			for (int i: set){
				for (int j : graph.get(i)) {
					if (visited[j]) continue;
					if (Arrays.binarySearch(routes[j], T) >= 0) return count;

					newSet.add(j);
					visited[j] = true;
				}
			}
			set = newSet;
		}

		return -1;
	}

	private boolean isConnect(int[] one, int[] two){
		for (int i = 0, j = 0; i < one.length && j < two.length;){
			if (one[i] == two[j]) return true;
			if (one[i] > two[j]) ++j;
			else ++i;
		}
		return false;
	}
}
