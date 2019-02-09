class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a.length == 0) return new int[0];
        int n = a.length;

        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; ++i) {
            while (deque.size() > 0 && deque.peekFirst() <= i - k) deque.pollFirst();
            while (deque.size() > 0 && (deque.peekLast() <= i - k || a[deque.peekLast()] <= a[i])) deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1) result[i - k + 1] = a[deque.peekFirst()];
        }
        return result;
    }
}

