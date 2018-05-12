class Solution {
	public int flipgame(int[] f, int[] b) {
		if (f.length == 0) return 0;

		int[] freq = new int[2001];
		boolean[] dup = new boolean[2001];

		for (int i = 0; i < f.length; ++i){
			if (f[i] == b[i]) dup[f[i]] = true;
			else {
				++freq[f[i]];
				++freq[b[i]];
			}
		}

		for (int i = 1; i < 2001; ++i){
			if (!dup[i] && freq[i] > 0) return i;
		}
		return 0;
	}
}
