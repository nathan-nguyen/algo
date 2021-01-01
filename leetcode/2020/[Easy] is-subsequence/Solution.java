class Solution {
	public boolean isSubsequence(String s, String t) {
		int si = 0;
		for (int ti = 0; si < s.length() && ti < t.length();++ti){
			if (t.charAt(ti) == s.charAt(si)) ++si;
		}
		if (si == s.length()) return true;
		return false;
        }
}
