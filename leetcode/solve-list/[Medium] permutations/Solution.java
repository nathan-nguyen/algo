class Solution {
	public List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0) return new ArrayList<>();

		List<Integer> l = new ArrayList<Integer>();
		for (int n : nums) l.add(n);
		return permute(l);
	}

	public List<List<Integer>> permute(List<Integer> l){
		if (l.size() == 1) {
			List<List<Integer>> rl = new ArrayList<>();
			List<Integer> nl = new ArrayList<>(l);
			rl.add(l);
			return rl;
		}

		List<List<Integer>> fl = new ArrayList<>();
		for (Integer e: l){
			List<Integer> nl = new ArrayList<>(l);
			nl.remove(e);
			List<List<Integer>> rl = permute(nl);

			for (List<Integer> el: rl) {
				el.add(0, e);
				fl.add(el);
			}
		}
		return fl;
		
	}
}
