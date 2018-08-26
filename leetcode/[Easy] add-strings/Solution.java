class Solution {
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int remember = 0;

		for (int i = 0; i < Math.max(num1.length(), num2.length()); ++i) {
			int n1 = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
			int n2 = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
			remember = n1 + n2 + remember;
			sb.append((char)(remember % 10 + '0'));
			remember /= 10;
		}
		if (remember > 0) sb.append(1);

		return sb.reverse().toString();
	}
}
