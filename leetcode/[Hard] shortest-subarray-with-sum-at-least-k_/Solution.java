class Solution {
    public int shortestSubarray(int[] a, int k) {
        int n = a.length;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        Deque<int[]> deque = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            sum += a[i];
            if (sum >= k) result = Math.min(result, i + 1);
            while (deque.size() > 0 && sum - deque.peekLast()[0] >= k) {
                int[] value = deque.pollLast();
                result = Math.min(result, i - value[1]);
            }
            while (deque.size() > 0 && sum <= deque.peekFirst()[0]) deque.pollFirst();
            deque.offerFirst(new int[]{sum, i});
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
