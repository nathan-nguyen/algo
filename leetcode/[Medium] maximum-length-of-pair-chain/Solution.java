class Solution {
    public int findLongestChain(int[][] p) {
        int n = p.length;
        Arrays.sort(p, (u, v) -> (u[1] == v[1]) ? Integer.compare(u[0], v[0]) : Integer.compare(u[1], v[1]));

        int end = Integer.MIN_VALUE;
        int count = 0;
        for (int[] c: p) {
            if (c[0] > end) {
                ++count;
                end = c[1];
            }
        }
        return count;
    }
}

