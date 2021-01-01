class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int distance = 1;
        for (int i = 1; i <= num; ++i) {
            if (i == distance * 2) distance = i;
            result[i] = 1 + result[i - distance];
        }
        return result;
    }
}
