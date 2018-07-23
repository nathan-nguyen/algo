class Solution {
	public boolean isNStraightHand(int[] hand, int W) {
		if (hand.length == 0 || W == 1) return true;

		if (hand.length % W != 0) return false;

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i: hand) {
			int value = map.getOrDefault(i, 0) + 1;
			map.put(i, value);
		}

		Arrays.sort(hand);

		for (int key: hand) {
			if (map.get(key) == 0) continue;
			for (int i = 0; i < W; ++i) {
				int value = map.getOrDefault(key + i, 0) - 1;
				if (value < 0) return false;
				map.put(key + i, value);
			}
		}
		return true;
	}
}
