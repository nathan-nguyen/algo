class Solution {
	public String removeKdigits(String num, int k) {
		int count = 0;

		for (int i = 0; i < num.length(); ++i) {
			if (num.charAt(i) == '0') {
				k-= count;
				count = 0;
			}
			else {
				++count;
				if (count > k) return removeKdigitsTail(num.substring(i - count + 1, num.length()), k);
			}
		}
		return "0";
	}

	private String removeKdigitsTail(String num, int k) {
		if (k == 0) return num;

		StringBuilder sb = new StringBuilder();

		int cur = 0;
		while (cur < num.length() && k > 0) {
			if (sb.length() > 0 && sb.charAt(sb.length() - 1) > num.charAt(cur)) {
				sb.setLength(sb.length() - 1);
				--k;
			}
			else sb.append(num.charAt(cur++));
		}

		sb.append(num.substring(cur, num.length()));
		sb.setLength(sb.length() - k);

		return sb.length() == 0 ? "0" : sb.toString();
	}
}
