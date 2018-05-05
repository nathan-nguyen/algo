class Solution {
	private List<List<String>> l = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		List<String> l0 = new ArrayList<>();
		l0.add("");
		l.add(l0);

		List<String> l1 = new ArrayList<>();
		l1.add("()");
		l.add(l1);

		List<String> l2 = new ArrayList<>();
		l2.add("(())");
		l2.add("()()");
		l.add(l2);

		return generate(n);
	}

	private List<String> generate(int n) {
		if (n < l.size()) return l.get(n);

		Set<String> ln = new HashSet<>();
		List<String> nl = generate(n - 1);

		for (String s: nl) ln.add("(" + s + ")");
		for (int i = 1; i <= n / 2; ++i){
			List<String> l1 = generate(i);
			List<String> l2 = generate(n - i);
			for (String s1: l1){
				for (String s2: l2){
					ln.add(s1 + s2);
					ln.add(s2 + s1);
				}
			}
		}
		l.add(new ArrayList<>(ln));

		return l.get(n);
	}
}
