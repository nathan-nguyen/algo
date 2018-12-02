class Solution {
    public int[] deckRevealedIncreasing(int[] d) {
        Arrays.sort(d);
        int n = d.length;

        Deque<Integer> position = new LinkedList<>();
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) position.offerFirst(n - 1 - i);

        for (int i: d) {
            int k = position.pollFirst();
            result[k] = i;
            if (position.size() > 0) position.offerLast(position.pollFirst());
        }
        return result;
    }
}
