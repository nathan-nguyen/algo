class Solution {
	public int leastBricks(List<List<Integer>> wall) {
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (List<Integer> list: wall) {
			int end = 0;
			for (int i = 0; i < list.size() - 1; ++i) {
				end += list.get(i);
				int value = map.getOrDefault(end, 0) + 1;
				max = Math.max(max, value);
				map.put(end, value);
			}
		}
		return wall.size() - max;
	}
}
