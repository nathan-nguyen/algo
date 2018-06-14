class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> l = new ArrayList<>();

		if (words.length == 0 || s.length() == 0) return l;

		HashMap<String, Integer> map = new HashMap<>();
		int index = 0;

		for (String w: words) {
			if (!map.containsKey(w)) map.put(w, index++);
		}

		int[] countOri = new int[index];
		for (String w: words) ++countOri[map.get(w)];

		int k = words[0].length(); 

		for (int i = 0; i < k; ++i){
			int start = i;
			int end = i;
			int counter = words.length;;
			int[] count = Arrays.copyOf(countOri, index);

			while (end <= s.length() - k){
				String se = s.substring(end, end + k);
				end += k;

				if (!map.containsKey(se)) {
					start = end;
					counter = words.length;
					count = Arrays.copyOf(countOri, index);
				}
				else {
					int id = map.get(se);
					if (count[id]-- >= 0) --counter;
					if (counter == 0 && count[id] == 0) l.add(start);
					while (counter == 0 || count[id] < 0){
						String sb = s.substring(start, start + k);
						++count[map.get(sb)];
						++counter;
						start += k;
					}
				}
			}
		}
		return l;
	}
}
