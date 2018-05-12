class Solution {
	public int firstUniqChar(String s) {
		int[] pos = new int[26];

		for (int i = 0; i < 26; ++i) pos[i] = Integer.MIN_VALUE;

		for (int i = 0; i < s.length(); ++i){
			int index = s.charAt(i) - 'a';
			if (pos[index] == Integer.MIN_VALUE) pos[index] = i;
			else if (pos[index] >= 0) pos[index] = Integer.MAX_VALUE;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 26; ++i){
			if (pos[i] >= 0) min = Math.min(min, pos[i]);
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
}
