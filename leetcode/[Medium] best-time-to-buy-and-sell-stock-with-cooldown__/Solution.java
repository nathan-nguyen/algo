class Solution {
    public int maxProfit(int[] p) {
        if (p.length == 0) return 0;
        int current = 0;
        int backOne = 0;
        int backTwo = 0;
        int hold = -p[0];

        for (int i = 1; i < p.length; ++i) {
            backTwo = backOne;
            backOne = current;
            current = Math.max(current, hold + p[i]);
            hold = Math.max(hold, backTwo - p[i]);
        }

        return current;
    }
}

