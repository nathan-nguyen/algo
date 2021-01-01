class Solution {
	public int longestPalindrome(String s) {
		int result = 0;
		int[] c = new int[128];

		for (int i = 0; i < s.length(); ++i) ++c[s.charAt(i)];
		for (int i = 'A'; i <= 'z'; ++i) result += c[i] / 2;

		return result * 2 == s.length() ? result * 2 : result * 2 + 1;
	}

        /*
        public int longestPalindrom(String s) {
                int result = 0;
                int[] c = new int[128];
                
                for (int i = 0; i < s.length(); ++i) {
                        int count = ++c[s.charAt(i)];
                        if (count % 2 == 0) result += 2;
                }
                return result == s.length() ? result : result + 1;
        }
        */
}
