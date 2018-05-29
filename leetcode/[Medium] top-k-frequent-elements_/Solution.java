class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int n : nums){
			if (!map.containsKey(n)) map.put(n, 1);
			else {
				int f = map.get(n);
				map.put(n, f + 1);
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((u, v) -> map.get(u) - map.get(v));

		for (int n: map.keySet()){
			pq.offer(n);
			if (pq.size() > k) pq.poll();
		}

		List<Integer> l = new ArrayList<>();
		while (pq.size() > 0) l.add(pq.poll());

		return l;
	}
}
