class Solution {
	public int reverse(int x) {
		boolean negative = x < 0;
		x = Math.abs(x);
		long result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		result = negative ? -result : result;
		return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int)result;	
	}
}
