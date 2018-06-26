class Solution {
	public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
		int n = quality.length;

		int[][] rate = new int[n][2];
		for (int i = 0; i < n; ++i){
			rate[i][0] = quality[i];
			rate[i][1] = wage[i];
		}

		Arrays.sort(rate, (u, v) -> (u[1] * v[0] == u[0] * v[1]) ? Integer.compare(u[0], v[0]) : Integer.compare(u[1] * v[0], u[0] * v[1]));

		int sum = 0;

		Queue<Integer> pq = new PriorityQueue<>((u, v) -> Integer.compare(v, u));

		for (int i = 0; i < k; ++i){
			sum += rate[i][0];
			pq.offer(rate[i][0]);
		}

		double minRate = (double) rate[k-1][1] / rate[k-1][0];
		double minCost = minRate * sum;

		for (int i = k; i < n; ++i){
			minRate = (double) rate[i][1] / rate[i][0];
			sum += rate[i][0];
			pq.offer(rate[i][0]);
			sum -= pq.poll();
			minCost = Math.min(minCost, minRate * sum);
		}
		return minCost;
        }
}
