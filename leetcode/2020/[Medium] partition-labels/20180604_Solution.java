class Solution {
	public List<Integer> partitionLabels(String s) {
		List<Integer> result = new ArrayList<>();

		int[] min = new int[26];
		int[] max = new int[26];

		Arrays.fill(min, Integer.MAX_VALUE);
		Arrays.fill(max, Integer.MIN_VALUE);

		List<Integer> l = new ArrayList<>();

		for (int i = 0; i < s.length(); ++i){
			int c = s.charAt(i) - 'a';

			if (min[c] == Integer.MAX_VALUE) l.add(c);

			min[c] = Math.min(min[c], i);
			max[c] = Math.max(max[c], i);
		}

		l.sort((u, v) -> min[u] - min[v]);

		int left = min[l.get(0)];
		int right = max[l.get(0)];

		for (int i = 1; i < l.size(); ++i){
			if (min[l.get(i)] > right){
				result.add(right - left + 1);
				left = min[l.get(i)];
				right = max[l.get(i)];
			}
			else right = Math.max(right, max[l.get(i)]);
		}

		result.add(right - left + 1);
		return result;
	}
}
