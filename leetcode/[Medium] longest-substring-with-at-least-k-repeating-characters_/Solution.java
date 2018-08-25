class Solution {
	public int longestSubstring(String s, int k) {
		if (s.length() < k) return 0;

		int[] c = new int[26];
		for (int i = 0; i < s.length(); ++i) ++c[s.charAt(i) - 'a'];

		if (verify(c, k)) return s.length();

		int max = 0;
		int begin = 0;

		for (int i = 0; i < s.length(); ++i){
			int index = s.charAt(i) - 'a';
			if (c[index] > 0 && c[index] < k){
				max = Math.max(max, longestSubstring(s.substring(begin, i), k));
				begin = i + 1;
			}
		}
		max = Math.max(max, longestSubstring(s.substring(begin, s.length()), k));
		return max;
	}

	private boolean verify(int[] c, int k) {
		for (int i = 0; i < 26; ++i) {
			if (c[i] > 0 && c[i] < k) return false;
		}
		return true;
	}
}
