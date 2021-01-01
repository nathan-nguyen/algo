class Solution {
	public int myAtoi(String s) {
		int pointer = 0;
		while (pointer < s.length() && s.charAt(pointer) == ' ') ++pointer;
		if (pointer == s.length()) return 0;

		int sign = 1;
		if (s.charAt(pointer) == '-') {
			++pointer;
			sign = -1;
		}
		else if (s.charAt(pointer) == '+') ++pointer;

		long result = 0;
		while (pointer < s.length()) {
			char c = s.charAt(pointer++);
			if (c < '0' || c > '9') break;
			result = result * 10 + (c - '0');
			
			if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			else if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		}

		return (int) (sign * result);
	}
}
