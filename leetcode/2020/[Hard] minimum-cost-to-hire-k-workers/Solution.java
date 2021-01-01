class Solution {
    public double mincostToHireWorkers(int[] q, int[] w, int k) {
        int n = q.length;
        int[][] r = new int[n][2];
        for (int i = 0; i < n; ++i) {
            r[i][0] = w[i];
            r[i][1] = q[i];
        }
        Arrays.sort(r, (u, v) -> Integer.compare(u[0] * v[1], u[1] * v[0]));
        Queue<Integer> pq = new PriorityQueue<>((u, v) -> Integer.compare(v, u));

        int sum = 0;
        double result = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            pq.offer(r[i][1]);
            sum += r[i][1];
            if (i >= k - 1) {
                result = Math.min(result, 1.0 * sum * r[i][0] / r[i][1]);
                sum -= pq.poll();
            }
        }
        return result;
    }
}

