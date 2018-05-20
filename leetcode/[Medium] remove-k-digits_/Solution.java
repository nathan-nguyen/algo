class Solution {
    public String removeKdigits(String s, int k) {

	if (k >= s.length()) return "0";

        int countZero = 0;
        int zeroIndex = -1;
	int del = 0;
	for (int i = 0; del <= k && i < s.length(); ++i){
		if (s.charAt(i) == '0') {
			++countZero;
			zeroIndex = i;
		}
		else ++del;
	}

	if (del <= k) return "0";

	s = s.substring(zeroIndex + 1, s.length());
	k -= (zeroIndex + 1 - countZero);

	if (k == 0) return s;

	StringBuilder sb = new StringBuilder();

	for (int i = 0; i < s.length() - 1; ++i){
		if (s.charAt(i) <= s.charAt(i + 1) || k <= 0) sb.append(s.charAt(i));
		else --k;
	}

	sb.append(s.charAt(s.length() - 1));
	if (k > 0) sb.setLength (sb.length() - k);

	return sb.toString();
    }
}

