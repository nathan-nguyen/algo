class Solution {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> l = new ArrayList<>();

		int n1 = nums1.length;
		int n2 = nums2.length;

		if (n1 * n2 * k == 0) return l;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]+a[1]-b[1]);

		for (int i = 0; i < n1; ++i) pq.offer(new int[]{nums1[i],nums2[0],0});

		while (k -- > 0 && !pq.isEmpty()){
			int[] p = pq.poll();
			l.add(new int[]{p[0],p[1]});

			if (p[2]+1 < n2) pq.offer(new int[]{p[0],nums2[p[2] + 1], p[2] + 1});
		}
		return l;
	}
}
