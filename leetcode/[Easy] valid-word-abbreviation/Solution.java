class Solution {
	public boolean validWordAbbreviation(String word, String abbr) {
		int diff = 0;
		int space = 0;
		for (int i = 0; i < abbr.length(); ++i) {
			int c = abbr.charAt(i) - '0';
			if (space + c == 0) return false;
			if (c >= 0 && c < 10) {
				space = space * 10 + c;
				--diff;
			}
			else {
				diff += space;
				space = 0;
				if (i + diff >= word.length() || abbr.charAt(i) != word.charAt(i + diff)) return false;
			}
		}
		diff += space;
		return abbr.length() + diff == word.length();
	}
}
