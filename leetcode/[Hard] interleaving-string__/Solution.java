class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		return isInterleave(s1, 0, s2, 0, s3, 0);
	}

	private boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
		if (i3 == s3.length()) return i1 == s1.length() && i2 == s2.length();

		boolean result = false;
		if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
			result = result || isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1);
		}
		if (!result && i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
			result = result || isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
		}

		return result;
	}
}
