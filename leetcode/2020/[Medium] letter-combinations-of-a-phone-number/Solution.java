class Solution {
	public List<String> letterCombinations(String d) {
		if (d.length() == 0 || d.indexOf("0") >= 0 || d.indexOf("1") >= 0) return new ArrayList<>();
		List<List<String>> l = new ArrayList<>();
		
		List<String> l2 = new ArrayList<>(Arrays.asList(new String[]{"a","b","c"}));
		List<String> l3 = new ArrayList<>(Arrays.asList(new String[]{"d","e","f"}));
		List<String> l4 = new ArrayList<>(Arrays.asList(new String[]{"g","h","i"}));
		List<String> l5 = new ArrayList<>(Arrays.asList(new String[]{"j","k","l"}));
		List<String> l6 = new ArrayList<>(Arrays.asList(new String[]{"m","n","o"}));
		List<String> l7 = new ArrayList<>(Arrays.asList(new String[]{"p","q","r","s"}));
		List<String> l8 = new ArrayList<>(Arrays.asList(new String[]{"t","u","v"}));
		List<String> l9 = new ArrayList<>(Arrays.asList(new String[]{"w","x","y","z"}));

		l.add(l2); l.add(l3); l.add(l4); l.add(l5); l.add(l6); l.add(l7); l.add(l8); l.add(l9);

		List<String> r = new ArrayList<>();
		r.add("");

		for (int i = 0; i < d.length(); ++i){
			char c = d.charAt(i);

			List<String> newr = new ArrayList<>();

			for (String s1: r){
				for (String s2: l.get(c - '0' - 2)){
					newr.add(s1 + s2);
				}
			}
			r = newr;
		}
		return r;
	}
}

