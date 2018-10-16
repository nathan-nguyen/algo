class Solution {
	public int minimumTotal(List<List<Integer>> t) {
		List<List<Integer>> dp = new ArrayList<>();

		for (int i = 0; i < t.size(); ++i) dp.add(new ArrayList<>());
		dp.get(0).add(t.get(0).get(0));

//   0
//  0 1
// 0 1 2

		for (int i = 1; i < t.size(); ++i){
			for (int j = 0; j <= i; ++j){
				int min = Integer.MAX_VALUE;
				if (j - 1 >= 0) min = Math.min(min, dp.get(i - 1).get(j - 1));
				if (j < i) min = Math.min(min, dp.get(i-1).get(j));
				dp.get(i).add(min + t.get(i).get(j));
			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < t.size() ; ++i) result = Math.min(result, dp.get(t.size() - 1).get(i));

		return result;
	}
}
