class Solution {
	public int longestValidParentheses(String s) {
		int start = 0, end = 0, d = 0;

		int count = 0;
		while (end < s.length()){
			if (s.charAt(end++) == '(') ++count;
			else {
				--count;
				if (count == 0) d = Math.max(d, end - start);
				else if (count < 0) {
					start = end;
					count = 0;
				}
			}
		}
	
		start = end = s.length() - 1;
		count = 0;
		while (end >= 0){
			if (s.charAt(end--) == ')') ++count;
			else {
				--count;
				if (count == 0) d = Math.max(d, start - end);
				else if (count < 0){
					start = end;
					count = 0;
				}
			}
		}
		return d;
        }
}
