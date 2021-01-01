class Solution {
    public String toHex(int n) {
	if (n == 0) return "0";

	String r = new String();

	for (int i = 0; i < 8; ++i){
		int num = 0;
		for (int j = 0; j < 4; ++j){
			if ((n & 1) == 1) num |= (1 << j);
			n = n >> 1;
		}
		r = (char) ((num < 10) ? num + '0' : 'a' + num - 10) + r;
	}

	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < 8; ++i){
		if (r.charAt(i) == '0' && sb.length() == 0) continue;
		else sb.append(r.charAt(i));
	}
	return sb.toString();
    }

}
