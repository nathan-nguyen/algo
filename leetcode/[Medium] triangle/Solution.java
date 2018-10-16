class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0) return 0;

		List<Integer> list = new ArrayList<>();

		for (List<Integer> row: triangle) {
			if (row.size() == 1) {
				list.addAll(row);
				continue;
			}

			List<Integer> nextList = new ArrayList<>();
			nextList.add(list.get(0) + row.get(0));
			for (int j = 1; j < list.size(); ++j) {
				nextList.add(row.get(j) + Math.min(list.get(j-1), list.get(j)));
			}
			nextList.add(list.get(list.size() - 1) + row.get(list.size()));
			list = nextList;
		}

		int min = Integer.MAX_VALUE;
		for (int i: list) min = Math.min(min, i);
		return min;
	}
}
