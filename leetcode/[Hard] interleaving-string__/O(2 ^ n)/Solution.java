class Solution {
	public boolean isInterleave(String s1, String s2, String s3){
		return isInterleave(s1, 0, s2, 0, s3);
	}

	public boolean isInterleave(String s1, int p1, String s2, int p2, String s3) {
		while (p1 < s1.length() && p2 < s2.length()){
			char c1 = s1.charAt(p1);
			char c2 = s2.charAt(p2);
			char c3 = s3.charAt(p1 + p2);
			if (c1 == c2){
				if (c1 != c3) return false;
				return isInterleave(s1, p1 + 1, s2, p2, s3) || isInterleave(s1, p1, s2, p2 + 1, s3);
			}
			if (c1 == c3) ++p1;
			else if (c2 == c3) ++p2;
			else return false;
		}
		if (p1 == s1.length()) return s2.substring(p2).equals(s3.substring(p1 + p2));
		else return s1.substring(p1).equals(s3.substring(p1 + p2));
	}
}
