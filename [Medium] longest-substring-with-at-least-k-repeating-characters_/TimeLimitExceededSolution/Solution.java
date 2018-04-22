class Solution {
	public int longestSubstring(String s, int k) {
		if (k <= 1) return s.length();

		int max = 0;
		for (int i = 0; i < s.length(); ++i){
			HashMap<Character, Integer> map = new HashMap<>();
			map.put(s.charAt(i), 1);
			for (int j = i + 1; j < s.length(); ++j){
				char c = s.charAt(j);
				if (map.containsKey(c)) map.put(c, map.get(c) + 1);
				else map.put(c, 1);

				if (isValid(map, k)) max = Math.max(j - i + 1, max);	
			}
		}
		return max;
	}

	private boolean isValid(HashMap<Character, Integer> map, int k){
		for (char c: map.keySet()){
			if (map.get(c) < k) return false;
		}
		return true;
	}
}

