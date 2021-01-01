class Solution {
	public int lengthOfLongestSubstring(String s) {
		int[] map = new int[128];

		int begin = 0, end = 0, d = 0;

		while (end < s.length()){
			if (map[s.charAt(end++)]++ > 0) {
				while (map[s.charAt(end-1)] > 1) --map[s.charAt(begin++)];
			}
			if (end - begin > d) d = end - begin;
		}
		return d;
	}
}
