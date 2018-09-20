class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

		if (map.getOrDefault(0, 0) > 2) result.add(Arrays.asList(0, 0, 0));

		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list);

		for (int i = 0; i < list.size(); ++i) {
			int first = list.get(i);
			if (first < 0 && map.get(first) > 1 && map.containsKey(-2 * first)) result.add(Arrays.asList(first, first, -2 * first));

			for (int j = i + 1; j < list.size() && 2 * list.get(j) + first <= 0; ++j) {
				int second = list.get(j);
				int last = 0 - first - second;

				if (!map.containsKey(last)) continue;

				if (last == second && map.get(second) < 2) break;

				result.add(Arrays.asList(first, second, last));
			}
		}

		return result;
	}
}

