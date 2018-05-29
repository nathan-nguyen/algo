class Solution {
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<>();

		for (String s: words){
			if (!map.containsKey(s)) map.put(s, 1);
			int v = map.get(s);
			map.put(s, v + 1);
		}

		PriorityQueue<String> pq = new PriorityQueue((u, v) -> {
			if (map.get(u) == map.get(v)) return -((String) u).compareTo((String) v);
			return map.get(u) - map.get(v);
		});

		for (String s: map.keySet()){
			pq.offer(s);
			if (pq.size() > k) pq.poll();
		}

		List<String> l = new ArrayList<>();
		while(pq.size() > 0) l.add(0, pq.poll());

		return l;
	}
}
