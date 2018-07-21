class Solution {
	public String longestPalindrome(String s) {
		for (int d = s.length(); d >= 0; --d) {
			for (int i = 0; i + d <= s.length(); ++i) {
				if (isPalindrome(s, i, i + d - 1)) return s.substring(i, i + d);
			}
		}

		return "";
	}

	private boolean isPalindrome(String s, int start, int end) {
		for (int i = 0; start + i < end - i; ++i) {
			if (s.charAt(start + i) != s.charAt(end - i)) return false;
		}
		return true;
	}
}
