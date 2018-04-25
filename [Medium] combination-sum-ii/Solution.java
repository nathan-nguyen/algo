class Solution {
	public List<List<Integer>> combinationSum2(int[] c, int target) {
		if (c.length == 0) return new ArrayList<>();

		Arrays.sort(c);
		return combinationSum2(c, target, -1);
	}

	private List<List<Integer>> combinationSum2(int[] c, int target, int index){
                List<List<Integer>> l = new ArrayList<>();
                
                if (target == 0){
                        List<Integer> cl = new ArrayList<>();
                        l.add(cl);
                        return l;
                }

		for (int i = index + 1; i < c.length && target >= c[i]; ++i){
                        if (i - 1 >= index + 1 && c[i] == c[i-1]) continue;
			for (List cl : combinationSum2(c, target - c[i], i)){
				cl.add(0, c[i]);
				l.add(cl);
			}
			
		}
		return l;
	}
}

