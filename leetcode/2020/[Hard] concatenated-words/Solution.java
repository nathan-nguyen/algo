class Solution {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> result = new ArrayList<>();

		if (words.length < 2) return result;

		HashSet<String> set = new HashSet<>();
		HashSet<Integer> sle = new HashSet<>();

		for (String s: words) {
			if (s.length() == 0) continue;
			set.add(s);
			sle.add(s.length());
		}

		List<Integer> lle = new ArrayList<>(sle);
		Collections.sort(lle);

		for (String s: words){
			if (check(lle, set, s) > 1) result.add(s);
		}
		return result;
		
	}

	private int check(List<Integer> lle, HashSet<String> set, String s){
		if (s.length() < lle.get(0)) return 0;

		if (s.length() == lle.get(0)) return set.contains(s) ? 1 : 0;

		for (int i = 0; i < lle.size() && lle.get(i) <= s.length(); ++i){
			int length = lle.get(i);
			if (set.contains(s.substring(0, length))) {
				if (length == s.length()) return 1;
				int k = check(lle, set, s.substring(length));
				if (k > 0) return k + 1;
			}
		}
		return 0;
	}	
}
