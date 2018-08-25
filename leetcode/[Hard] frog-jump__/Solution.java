class Solution {
	public boolean canCross(int[] stones) {
		if (stones.length == 1) return true;
		if (stones.length > 1 && stones[1] != 1) return false;

		HashSet<String> set = new HashSet<>();

		HashSet<Integer> step = new HashSet<>();
		for (int e: stones) step.add(e);

		return dfs(step, stones[stones.length - 1], 1, 1, set);
	}

	private boolean dfs(HashSet<Integer> step, int last, int current, int count, HashSet<String> set) {
		if (current > last || !step.contains(current) || count == 0 || set.contains(current + "_" + count)) return false;
		if (current == last) return true;

		set.add(current + "_" + count);
		if (dfs(step, last, current + (count + 1), count + 1, set)) return true;
		if (dfs(step, last, current + count, count, set)) return true;
		if (dfs(step, last, current + (count - 1), count - 1, set)) return true;

		return false;
	}
}
