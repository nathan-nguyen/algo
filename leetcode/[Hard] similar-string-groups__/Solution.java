class Solution {
	public int numSimilarGroups(String[] A) {
		if (A.length == 0) return 0;
		int n = A.length;

		HashSet<String> set = new HashSet<>();
		for (String s: A) set.add(s);

		List<String> list = new ArrayList<>(set);
		int[] pr = new int[list.size()];
		int[] sz = new int[list.size()];

		for (int i = 0; i < list.size(); ++i) {
			pr[i] = i;
			sz[i] = 1;
		}

		for (int i = 1; i < list.size(); ++i) {
			for (int j = 0; j < i; ++j) {
				if (verify(list.get(i), list.get(j))) {
					union(i, j, pr, sz);
				}
			}
		}

		int count = 0;
		for (int i = 0; i < list.size(); ++i) {
			if (pr[i] == i) ++count;
		}

		return count;
	}

	private void union(int i, int j, int[] pr, int[] sz) {
		while (pr[i] != i) i = pr[i];
		while (pr[j] != j) j = pr[j];

		if (i == j) return;
		if (sz[i] >= sz[j]) {
			pr[j] = i;
			sz[i] += sz[j];
		} else {
			pr[i] = j;
			sz[j] += sz[i];
		}
	}

	private boolean verify(String s1, String s2) {
		int count = 0;

		for (int i = 0; i < s1.length(); ++i) {
			if (s1.charAt(i) != s2.charAt(i)) ++count;
		}
		return count == 2;
	}
}
