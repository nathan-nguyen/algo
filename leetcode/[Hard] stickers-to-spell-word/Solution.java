class Solution {
	private Map<String, Integer> map;

	public int minStickers(String[] stickers, String target) {
		List<int[]> l = new ArrayList<>();
		for (String s: stickers) l.add(count(s));

		int[] goal = count(target);

		map = new HashMap<>();

		return minSticker(l, goal);
	}

	private int minSticker(List<int[]> l, int[] goal){
		String key = getKey(goal);
		if (key.length() == 0) return 0;

		if (map.containsKey(key)) return map.get(key);
		int ans = Integer.MAX_VALUE;

		for (int[] w: l){
			int[] tmp = Arrays.copyOfRange(goal, 0, 26);
			if (diff(w, tmp) == 0) continue;

			int lc = minSticker(l, tmp);
			if (lc == -1) return -1;

			ans = Math.min(ans, lc + 1);
		}
		if (ans != Integer.MAX_VALUE) {
			map.put(key, ans);
			return ans;
		}
		return -1;
	}

	private String getKey(int[] goal){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; ++i){
			if (goal[i] > 0) {
				sb.append((char)(i + 'a'));
				sb.append(goal[i]);
			}
		}
		return sb.toString();
	}

	private int diff(int[] left, int[] right){
		int change = 0;
		for (int i = 0; i < 26; ++i){
			if (right[i] * left[i] == 0) continue;

			int lc = Math.min(left[i], right[i]);
			change += lc;
			right[i] -= lc;
		}
		return change;
	}

	private int[] count(String s){
		int[] c = new int[26];
		for (int i = 0; i < s.length(); ++i) ++c[s.charAt(i) - 'a'];
		return c;
	}
}
