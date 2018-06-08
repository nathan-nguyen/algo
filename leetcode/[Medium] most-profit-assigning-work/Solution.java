class Solution {
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		int n = difficulty.length;

		if (n == 0 || worker.length == 0) return 0;

		int[][] v = new int[n][2];

		for (int i = 0; i < n; ++i) {
			v[i][0] = difficulty[i];
			v[i][1] = profit[i];
		}

		Arrays.sort(v, (x, y) -> {
			if (x[0] == y[0]) return y[1] - x[1];
			else return x[0] - y[0];
		});
		Arrays.sort(difficulty);

		for (int i = 1; i < n; ++i) v[i][1] = Math.max(v[i][1], v[i-1][1]);

		int result = 0;
		for (int w: worker){
			int index = Arrays.binarySearch(difficulty, w);
			if (index >= 0) result += v[index][1];
			else {
				index = -index - 1;
				if (index == 0) continue;
				else result += v[index - 1][1];
			}
		}
		return result;
        }
}
