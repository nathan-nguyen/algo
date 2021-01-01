class Solution {
	public List<Integer> partitionLabels(String s) {
		int[] all = new int[26];
		int[] count = new int[26];

		for (int i = 0; i < s.length(); ++i) ++all[s.charAt(i) - 'a'];

		int local = 0;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < s.length(); ++i) {
			++local;
			++count[s.charAt(i) - 'a'];
			if (canBreak(all, count)) {
				result.add(local);
				local = 0;
			}
		}

		if (local > 0) result.add(local);
		return result;
	}

	private boolean canBreak(int[] all, int[] count) {
		int result = 0;
		for (int i = 0; i < 26 && result == 0; ++i) result += count[i] * (all[i] - count[i]);
		return result == 0;
	}
}
