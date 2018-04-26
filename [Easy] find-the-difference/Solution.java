class Solution {
	public char findTheDifference(String s, String t) {
		int n = s.length();
		char c = t.charAt(n);

		for (int i = 0; i < n; ++i) {
			c ^= s.charAt(i);
			c ^= t.charAt(i);
		}

		return c;
	}
}
