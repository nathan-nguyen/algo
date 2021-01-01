class Solution {
	public int leastBricks(List<List<Integer>> wall) {
		HashMap<Integer, Integer> map = new HashMap<>();

		int max = 0;
		for (List<Integer> wl : wall){
			int end = 0;
			for (int i = 0; i < wl.size() - 1; ++i){
				end += wl.get(i);
				if (map.containsKey(end)){
					int freq = map.get(end);
					map.put(end, freq + 1);
				}
				else map.put(end, 1);
				max = Math.max(max, map.get(end));
			}
		}
		return wall.size() - max;
        }
}
