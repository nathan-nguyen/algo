class Solution {
	public int networkDelayTime(int[][] times, int N, int K) {
		--K;

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < N; ++i) graph.add(new ArrayList<>());

		int[] finalTime = new int[N];
		Arrays.fill(finalTime, Integer.MAX_VALUE);

		HashMap<String, Integer> edge = new HashMap<>();
		for (int[] t: times){
			int u = t[0] - 1;
			int v = t[1] - 1;
			graph.get(u).add(v);
			int d = edge.getOrDefault(u + "_" + v, Integer.MAX_VALUE);
			d = Math.min(d, t[2]);
			edge.put(u + "_" + v, d);	
		}

		finalTime[K] = 0;
		HashSet<Integer> set = new HashSet<>();
		set.add(K);

		while (set.size() > 0){
			HashSet<Integer> newSet = new HashSet<>();
			for (int u : set){
				for (int v: graph.get(u)){
					int e = edge.get(u + "_" + v);

					if (finalTime[u] + e < finalTime[v]) {
						newSet.add(v);
						finalTime[v] = finalTime[u] + e;
					}
				}
			}
			set = newSet;
		}

		int t = 0;
		for (int i = 0; i < N; ++i) t = Math.max(t, finalTime[i]);
		return (t == Integer.MAX_VALUE) ? -1 : t;	
	}
}
