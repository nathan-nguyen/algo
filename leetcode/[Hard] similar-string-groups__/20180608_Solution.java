class Solution {
	public int numSimilarGroups(String[] input) {
		if (input.length < 2) return input.length;

		Arrays.sort(input);
		List<String> l = new ArrayList<>();
		l.add(input[0]);

		for (int i = 1; i < input.length; ++i){
			if (input[i].equals(input[i-1])) continue;
			l.add(input[i]);
		}

		int n = l.size();
		int[] sz = new int[n];
		int[] p = new int[n];

		Arrays.fill(sz, 1);
		for (int i = 0; i < n; ++i) p[i] = i;

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < i; ++j){
				if (isSimilar(l.get(i), l.get(j))) union(i, j, sz, p);
			}
		}

		int count = 0;
		for (int i = 0; i < n; ++i) if (i == p[i]) ++count;
		return count;
	}

	private void union(int i, int j, int[] sz, int[] p){
		while (p[i] != i) i = p[i];
		while (p[j] != j) j = p[j];
		if (i == j) return;

		if (sz[i] < sz[j]) {
			p[i] = j;
			sz[j] += sz[i];
		}
		else {
			p[j] = i;
			sz[i] += sz[j];
		}
	}

	private boolean isSimilar(String a, String b){
		int diff = 0;
		for (int i = 0; i < a.length() && diff < 3; ++i){
			if (a.charAt(i) != b.charAt(i)) ++diff;
		}
		return diff == 2;
	}
}
