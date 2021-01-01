class Solution {
	public int reversePairs(int[] a) {
		if (a.length == 0) return 0;

		int n = a.length;
		long[] b = new long[2 * n];

		for (int i = 0; i < n; ++i){
			b[2 * i] = a[i];
			b[2 * i + 1] = (long)2 * a[i];
		} 

		Arrays.sort(b);
		HashMap<Long, Integer> map = new HashMap<>();

		int diff = 0;
		map.put(b[0], diff++);

		for (int i = 1; i < 2 * n; ++i){
			if (b[i] == b[i-1]) continue;
			map.put(b[i], diff++);	
		}

		int[] tree = new int[diff + 1];

		int count = 0;
		for (int i = 0; i < n; ++i){
			count += (i - get(map.get((long)2 * a[i]), tree));
			update(map.get((long)a[i]), tree);
		}

		return count;
	}

	private int get(int index, int[] tree){
		++index;
		int sum = 0;
		while (index > 0) {
			sum += tree[index];
			index -= index & (-index);
		}
		return sum;
	}

	private void update(int index, int[] tree){
		++index;
		while (index < tree.length){
			++tree[index];
			index += index & (-index);
		}
	}
}
