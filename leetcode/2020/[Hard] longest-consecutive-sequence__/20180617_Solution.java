class Solution {	
	public int longestConsecutive(int[] a) {
		int max = 0;

		HashSet<Integer> set = new HashSet<>();
		for (int k : a) set.add(k);

		for (int k : a){
			if (!set.contains(k)) continue;

			int count = 1;
			for (int i = k; i < Integer.MAX_VALUE && set.contains(i + 1); ++i) {
				++count;
				set.remove(i + 1);
			}
			for (int i = k; i > Integer.MIN_VALUE && set.contains(i - 1); --i) {
				++count;
				set.remove(i - 1);
			}
			max = Math.max(max, count);
		}
		return max;
	}
}
