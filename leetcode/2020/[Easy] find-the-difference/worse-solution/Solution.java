class Solution {
	public char findTheDifference(String s, String t) {
		int[] count = new int[26];

		for (int i = 0; i < s.length(); ++i) {
			++count[s.charAt(i) - 'a'];
			--count[t.charAt(i) - 'a'];
		}
		--count[t.charAt(t.length() - 1) - 'a'];

		for (int i = 0; i < 26; ++i){
			if (count[i] < 0) return (char) (i + 'a');
		}

		return '\0';
	}
}
