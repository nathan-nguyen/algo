class Solution {
	public List<Integer> grayCode(int n) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < (1 << n); ++i) set.add(i);

		List<Integer> result = new ArrayList<>();
		grayCode(result, n, 0, set);

		return result;
	}

	private void grayCode(List<Integer> result, int n, int cur, HashSet<Integer> set){
		result.add(cur);
		set.remove(cur);

		if (set.size() == 0) return;

		for (int i = 0; i < n; ++i){
			int k = cur ^ (1 << i);
			if (!set.contains(k)) continue;

			grayCode(result, n, k, set);
			if (set.size() == 0) return;
		}

		result.remove(result.size() - 1);
		set.add(cur);
	}
}
