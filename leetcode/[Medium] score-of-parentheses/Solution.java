class Solution {
	public int scoreOfParentheses(String s) {
		if (s.length() == 0) return 0;
		if (s.length() == 2) return 1;

		int count = 0;
		for (int i = 0; i < s.length(); ++i){
			if (s.charAt(i) == '(') ++count;
			else {
				if (--count == 0) {
					int left = scoreOfParentheses(s.substring(1, i));
					int right = scoreOfParentheses(s.substring(i + 1));
					return (left == 0) ? 1 + right : 2 * left + right;
				}
			}
		}
		return scoreOfParentheses(s.substring(1, s.length() - 1));
	}
}
