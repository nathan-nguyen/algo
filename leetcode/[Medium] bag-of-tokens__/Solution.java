class Solution {
    public int bagOfTokensScore(int[] t, int p) {
        Arrays.sort(t);
        int max = 0;
        int count = 0, s = 0, e = t.length - 1;
        while (s <= e) {
            if (t[s] <= p) {
                p -= t[s++];
                ++count;
                max = Math.max(max, count); 
            }
            else {
                if (count == 0) return max;
                p += t[e--];
                --count;
            }
        }
        return max;
    }
}
