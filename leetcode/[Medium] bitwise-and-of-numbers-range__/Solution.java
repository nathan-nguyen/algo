class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int diff = n - m;

	if (diff == 0) return m;

	int min = 0;
	int result = 0;
	for (int i = 0; i < 31; ++i){
		int max = (1 << (i + 1)) - 1;

		if (((m >> i) & 1) == 0) continue;

		min |= 1 << i;

		if (min + diff > 0 && min + diff <= max) result |= 1 << i;
	}
	return result;
    }
}
