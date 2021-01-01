class Solution {
	public boolean canCross(int[] stones) {
		if (stones.length == 0) return false;

		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

		for (int i = 0; i < stones.length; ++i){
			if (map.containsKey(stones[i])) continue;
			map.put(stones[i], new HashSet<Integer>());
		}

		map.get(stones[0]).add(0);

		for (int i = 0; i < stones.length - 1; ++i){
			for (int k: map.get(stones[i])){
				if (k > 0 && map.containsKey(stones[i] + k)) map.get(stones[i] + k).add(k);
				if (k - 1 > 0 && map.containsKey(stones[i] + k - 1)) map.get(stones[i] + k - 1).add(k - 1);
				if (k + 1 > 0 && map.containsKey(stones[i] + k + 1)) map.get(stones[i] + k + 1).add(k + 1);
			}
		}
		return map.get(stones[stones.length - 1]).size() > 0;
	}
}
