class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		Set s1 = new HashSet(), s2 = new HashSet();
		

		for (int i = 0;i < s.length() - 9; ++i) {
			String sub = s.substring(i, i + 10);
			if (s1.contains(sub)) s2.add(sub);
			else s1.add(sub);
		}

		return new ArrayList<>(s2);
	}
}
