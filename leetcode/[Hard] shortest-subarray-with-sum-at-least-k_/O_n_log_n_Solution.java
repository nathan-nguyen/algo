class Solution {
    public int shortestSubarray(int[] a, int k) {
        int n = a.length;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        Queue<int[]> pq = new PriorityQueue<>((u, v) -> u[0] == v[0] ? -Integer.compare(u[1], v[1]) : Integer.compare(u[0], v[0]));
        for (int i = 0; i < n; ++i) {
            sum += a[i];
            if (sum >= k) result = Math.min(result, i + 1);
            while (pq.size() > 0 && sum - pq.peek()[0] >= k) {
                int[] value = pq.poll();
                result = Math.min(result, i - value[1]);
            }
            pq.offer(new int[]{sum, i});
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
