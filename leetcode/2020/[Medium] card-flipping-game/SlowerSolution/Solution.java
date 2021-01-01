class Solution {
	public int flipgame(int[] f, int[] b) {
		Set<Integer> set = new HashSet<>();

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < f.length; ++i){
			if (f[i] == b[i]) set.add(f[i]);
		}

		for (int i = 0; i < f.length; ++i){
			if (!set.contains(f[i])) min = Math.min(min, f[i]);
			if (!set.contains(b[i])) min = Math.min(min, b[i]);
		}

		return (min == Integer.MAX_VALUE) ? 0 : min;
	}
}
