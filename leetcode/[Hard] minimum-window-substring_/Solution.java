class Solution {
	public String minWindow(String s, String t) {
		if (t.length() == 0) return "";

		int[] map = new int[128];

		for (int i = 0; i < t.length(); ++i) ++map[t.charAt(i)];

		int begin = 0, end  = 0, head = 0, d = Integer.MAX_VALUE, counter = t.length();

		while (end < s.length()){
			if (map[s.charAt(end++)]-- > 0) --counter;

			while (counter == 0){
				if (end - begin < d) {
					d = end - begin;
					head = begin;
				}
				// Because even if begin = end, if char c is not in t, then maximum map[c] will be 0
				if (++map[s.charAt(begin++)] > 0) ++counter;
			}
		}
		return (d == Integer.MAX_VALUE) ? "" : s.substring(head, head + d);
	}
}
