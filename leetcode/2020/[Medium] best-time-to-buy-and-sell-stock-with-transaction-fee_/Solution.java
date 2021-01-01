class Solution {
    public int maxProfit(int[] p, int f) {
        int hold = -p[0];
        int notHold = 0;
        for (int i: p) {
            hold = Math.max(hold, notHold - i);
            notHold = Math.max(notHold, hold + i - f);
        }
        return notHold;
    }
}

