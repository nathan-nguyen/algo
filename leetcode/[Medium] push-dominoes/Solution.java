class Solution {
	private static int MIN = -1000001;
	private static int MAX = 1000001;

	public String pushDominoes(String dom) {
		if (dom.length() == 0) return "";

		int n = dom.length();

		int[] left = new int[n];
		int[] right = new int[n];

		right[0] = dom.charAt(0) == 'R' ? 0 : MIN;
		left[n-1] = (dom.charAt(n-1) == 'L') ? (n - 1) : MAX;

		for (int i = 1; i < n; ++i){
			if (dom.charAt(i) == 'R') right[i] = i;
			else if (dom.charAt(i) == 'L') right[i] = MIN;
			else right[i] = right[i - 1];

			if (dom.charAt(n - 1 - i) == 'L') left[n - 1 - i] = n - 1 - i;
			else if (dom.charAt(n - 1 - i) == 'R') left[n - 1 - i] = MAX;
			else left[n - 1 - i] = left[n - i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i){
			if (dom.charAt(i) != '.') sb.append(dom.charAt(i));
			else {
				if (right[i] == MIN && left[i] == MAX) sb.append('.');
				else if (i - right[i] == left[i] - i) sb.append('.');
				else if (i - right[i] < left[i] - i) sb.append('R');
				else sb.append('L');
			}
		}
		return sb.toString();
	}
}
