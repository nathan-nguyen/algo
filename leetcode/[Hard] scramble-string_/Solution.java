class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) return false;

		return verify(s1, s2);
	}

	private boolean verify(String s1, String s2){
		if (s1.equals(s2)) return true;
		int[] count = new int[128];

		for (int i = 0; i < s1.length(); ++i){
			++count[s1.charAt(i)];
			--count[s2.charAt(i)];
		}
		for (int i = 0; i < 128; ++i) if (count[i] != 0) return false;

		for (int i = 1; i < s1.length(); ++i){
			if (verify(s1.substring(0, i) , s2.substring(0, i)) && verify(s1.substring(i), s2.substring(i))) return true;
			if (verify(s1.substring(0, i), s2.substring(s1.length() - i)) && verify(s1.substring(i), s2.substring(0, s1.length() - i))) return true;
		}
		return false;
	}
}

