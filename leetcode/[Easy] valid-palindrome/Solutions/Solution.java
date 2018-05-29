class Solution {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();

		int i = 0, j = s.length() - 1;

        	while (i < j){
			char c1 = s.charAt(i);
			char c2 = s.charAt(j);

			if (c1 < 48 || c1 > 122 || (c1 > 57 && c1 < 65) || (c1 > 90 && c1 < 97)){
				++i;
				continue;
			}
			if (c2 < 48 || c2 > 122 || (c2 > 57 && c2 < 65) || (c2 > 90 && c2 < 97)){
                               	--j;
                                continue;
                        }
			if (c1 != c2) return false;

			++i;
			--j;
		}
		return true;
	}
}
