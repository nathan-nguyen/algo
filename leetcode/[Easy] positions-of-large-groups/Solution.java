class Solution {
	public List<List<Integer>> largeGroupPositions(String s) {
		List<List<Integer>> result = new ArrayList<>();

		if (s.length() == 0) return result;

		int count = 1;
		for (int i = 1; i < s.length(); ++i){
			if (s.charAt(i) != s.charAt(i-1)){
				if (count >= 3) {
					List<Integer> l = new ArrayList<>();
					l.add(i-count);
					l.add(i-1);
					result.add(l);
				}
				count = 1;
			}
			else ++count;
		}

		if (count >= 3) {
			List<Integer> l = new ArrayList<>();
			l.add(s.length() - count);
			l.add(s.length() - 1);
			result.add(l);
		}
		return result;
	}
}
