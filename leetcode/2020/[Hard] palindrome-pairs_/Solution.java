class Solution {
	public List<List<Integer>> palindromePairs(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();
 
		List<List<Integer>> l = new ArrayList<>();
		for (int i = 0; i < words.length; ++i) map.put(words[i], i);

		for (int i = 0; i < words.length; ++i) {
			for (String s: getPairLeft(words[i])){
				if (map.containsKey(s)){
					int val = map.get(s);
					if (set.contains(i + "_" + val)) continue;

					List<Integer> pair = new ArrayList<>();
					pair.add(i);	pair.add(val);
					l.add(pair);
					set.add(i + "_" + val);
				}
			}

			for (String s: getPairRight(words[i])){
                                if (map.containsKey(s)){
					int val = map.get(s);
					if (set.contains(val + "_" + i)) continue;

                                        List<Integer> pair = new ArrayList<>();
                                        pair.add(val);	pair.add(i);
                                        l.add(pair);
					set.add(val + "_" + i);
                                }   
                        }
		}
		return l;
	}

	private List<String> getPairLeft(String s){
		List<String> result = new ArrayList<>();

		String rv = (new StringBuilder(s)).reverse().toString();
		if (!isPalindrome(s)) result.add(rv);
		else if (s.length() > 0) result.add("");

		for (int i = s.length() - 1; i > 0; --i){
			if (isPalindrome(s.substring(i))) result.add(rv.substring(s.length() - i)); 
		}
		return result;
	}

	private List<String> getPairRight(String s){
		List<String> result = new ArrayList<>();

		if (isPalindrome(s) && s.length() > 0) result.add("");

		String rv = (new StringBuilder(s)).reverse().toString();

		for (int i = 1; i < s.length(); ++i){
			if (isPalindrome(s.substring(0, i))) result.add(rv.substring(0, s.length() - i));
		}
		return result;
	}

	private boolean isPalindrome(String s){
		for (int i = 0; i < s.length() / 2; ++i){
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
		}
		return true;
	}
}
