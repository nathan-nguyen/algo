class Solution {
	public boolean isNStraightHand(int[] hand, int W) {
		if (hand.length == 0) return true;
		if (W <= 0 || hand.length % W != 0) return false;

		HashMap<Integer, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();

		int min = Integer.MAX_VALUE;
		for (int e: hand) {
			set.add(e);
			min = Math.min(min, e);
			int val = map.getOrDefault(e, 0);
			map.put(e, val + 1);
		}

		List<Integer> l = new ArrayList<>(set);
		Collections.sort(l);

		int k = hand.length / W;
		// Index in l
		int start = 0;
		while (k -- > 0){
			int nextStart = start + W;
			for (int i = 0; i < W; ++i){
				int val = map.getOrDefault(l.get(start) + i, 0);

				if (val == 0) return false;
				map.put(l.get(start) + i, val - 1);
				if (val > 1) nextStart = Math.min(nextStart, start + i);
			}
			start = nextStart;
		}

		return true;
	}
}
