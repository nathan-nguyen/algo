class Solution {
	public List<List<Integer>> combinationSum(int[] c, int target) {
		if (c.length == 0) return new ArrayList<>();

		Arrays.sort(c);
		return combinationSum(c, target, 0);
	}

	private List<List<Integer>> combinationSum(int[] c, int target, int index){
                List<List<Integer>> l = new ArrayList<>();
                
                if (target == 0){
                        List<Integer> cl = new ArrayList<>();
                        l.add(cl);
                        return l;
                }
                
		for (int i = index; i < c.length && target >= c[i]; ++i){
			for (List cl : combinationSum(c, target - c[i], i)){
				cl.add(0, c[i]);
				l.add(cl);
			}
			
		}
		return l;
	}
}


