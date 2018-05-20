class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		if (m == 0) return 0;

		int mul = 1;
		while (m != n){
			m = m >> 1;
			n = n >> 1;
			mul = mul << 1;
		}

		return m * mul;
	}
}

