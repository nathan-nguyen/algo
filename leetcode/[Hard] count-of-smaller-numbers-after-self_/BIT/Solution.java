class Solution {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> l = new ArrayList<>();
		if (nums.length == 0) return l;

		int n = nums.length;

		int[] a = new int[n];
		for (int i = 0; i < n; ++i) a[i] = nums[i];

		Arrays.sort(a);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int diff = 0;

		map.put(a[0], diff++);

		for (int i = 1; i < n; ++i){
			if (a[i] != a[i-1]) map.put(a[i], diff++);
		}

		int[] tree = new int[diff + 1];
		int[] result  = new int[n];

		for (int i = n-1; i >= 0; --i){
			int index = map.get(nums[i]);
			result[i] = get(tree, index - 1);
			update(tree, index);
		}

		for (int k: result) l.add(k);

		return l;
	}

	private int get(int[] tree, int index){
		++index;
		int sum = 0;

		while (index > 0) {
			sum += tree[index];
			index -= index & (-index);
		}
		return sum;
	}

	private void update(int[] tree, int index){
		++index;
		while (index < tree.length){
			++tree[index];
			index += index & (-index);
		}
	}
}
