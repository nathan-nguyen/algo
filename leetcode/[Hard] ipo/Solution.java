class Solution {
	public int findMaximizedCapital(int k, int w, int[] p, int[] c) {
		if (k == 0 || p.length == 0) return w;

		List<Integer> l = new ArrayList<>();

		for (int i = 0; i < p.length; ++i){
			if (p[i] > 0) l.add(i);
		}

		l.sort((u, v) -> (c[u] == c[v]) ? Integer.compare(p[u], p[v]) : Integer.compare(c[u], c[v]));

		Queue<Integer> pq = new PriorityQueue<>((u, v) -> Integer.compare(p[v], p[u]));

		for (int i = 0; i < l.size(); ++i){
			while (w < c[l.get(i)]) {
				if (pq.size() == 0) return w;

				int last = pq.poll();
				w += p[last];
				if (--k == 0) return w;
			}
			pq.offer(l.get(i));
		}

		while (pq.size() > 0 && k-- > 0) w += p[pq.poll()];
		return w;
	}
}
