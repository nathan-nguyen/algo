class Solution {
	public boolean isPalindrome(String s) {
		s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
		return s.equals((new StringBuilder(s)).reverse().toString());
	}
}
