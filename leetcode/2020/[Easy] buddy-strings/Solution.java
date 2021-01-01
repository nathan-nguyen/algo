class Solution {
	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length()) return false;

		int count = 0;
		int first = -1;
		int repeat = 0;
		boolean isRepeat = false;

		for (int i = 0; i < A.length(); ++i){
			if (A.charAt(i) != B.charAt(i)){
				++count;
				if (count == 1) first = i;
				else if (count == 2){
					if (A.charAt(first) != B.charAt(i) || A.charAt(i) != B.charAt(first)) return false;
				}
				else return false;
			}
			int shift = A.charAt(i) - 'a';
			if (!isRepeat && repeat >> shift == 1) isRepeat = true;
			repeat |= (1 << shift);
			
		}
		if (count == 1) return false;
		return (count == 2 || isRepeat);
	}
}
