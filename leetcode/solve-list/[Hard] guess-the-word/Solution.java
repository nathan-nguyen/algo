/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
	
	public void findSecretWord(String[] wordlist, Master master){
		List<String> wl = new ArrayList<String>();

		for (String s: wordlist) wl.add(s);

		findSecretWord(wl, master);
	}

	public void findSecretWord(List<String> wordlist, Master master) {
		int n = wordlist.size();

		HashMap<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			String left = wordlist.get(i);
			for (int j = i + 1; j < n; ++j){
				String right = wordlist.get(j);
				int r = match(left, right);
				put(map, left, right, r);
				put(map, right, left, r);
			}
		}


		int d = Integer.MAX_VALUE;
		String target = "";	
		for (String s: wordlist) {
			int freq = getFreq(map, s);
			if (freq < d) {
				d = freq;
				target = s;
			}
		}

		int k = master.guess(target);
		if (k == 6) return;

		List<String> l = map.get(target + k);
		map.clear();
		findSecretWord(l, master);
	}

	private int getFreq(HashMap<String, List<String>> map, String s){
		int d0 = map.getOrDefault(s + 0, new ArrayList<>()).size();
		int d1 = map.getOrDefault(s + 1, new ArrayList<>()).size();
		int d2 = map.getOrDefault(s + 2, new ArrayList<>()).size();
		int d3 = map.getOrDefault(s + 3, new ArrayList<>()).size();
		int d4 = map.getOrDefault(s + 4, new ArrayList<>()).size();
		int d5 = map.getOrDefault(s + 5, new ArrayList<>()).size();
		return (Math.abs(d1 - d0) + Math.abs(d2 - d1) + Math.abs(d3 - d2) + Math.abs(d4 - d3) + Math.abs(d5 - d4) ) / 5;
	}

	private void put(HashMap<String, List<String>> map, String s1, String s2, int match){
		List<String> l;
		if (map.containsKey(s1 + match)) l = map.get(s1 + match);
		else {
			l = new ArrayList<String>();
			map.put(s1 + match, l);
		}
		l.add(s2);
	}

	private int match(String s1, String s2){
		int count = 0;
		for (int i = 0; i < 6; ++i){
			if (s1.charAt(i) == s2.charAt(i)) ++count;
		}
		return count;
	}
}
