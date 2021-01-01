class Solution {
	public int smallestDistancePair(int[] a, int k) {
		Arrays.sort(a);

		int n = a.length;

		PriorityQueue<Integer> pq = new PriorityQueue<>((u, v) -> v - u);

		int max = Integer.MAX_VALUE;

		for (int i = 0; i < n; ++i){
			for (int j = i + 1; j < n && a[j] - a[i] < max; ++j){
				pq.offer(a[j] - a[i]);
				if (pq.size() > k) max = Math.min(max, pq.poll());
			}
		}
		return pq.peek();
	}
}
