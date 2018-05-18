class Solution {
	public int[][] updateMatrix(int[][] matrix) {
		int[][] result = new int[matrix.length][matrix[0].length];
		if (matrix[0].length == 0) return result;

		int n = matrix.length;
		int m = matrix[0].length;

		for (int i = 0; i < n; ++i) Arrays.fill(result[i], -1);

		ArrayList<Integer> queue = new ArrayList<>();
		int value = 0;

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				if (matrix[i][j] == 0) queue.add(i * m + j);
			}
		}

		int d = 0;

		while (queue.size() > 0){
			for (int q: queue) result[q / m][q % m] = d;

			ArrayList<Integer> newQueue = new ArrayList<>();

			for (int q: queue) {
				int i = q / m;
				int j = q % m;

				if (i - 1 >= 0 && result[i-1][j] == -1) newQueue.add( (i-1) * m + j);
				if (j - 1 >= 0 && result[i][j-1] == -1) newQueue.add( i * m + j - 1);
				if (j + 1 < m  && result[i][j+1] == -1) newQueue.add( i * m + j + 1);
				if (i + 1 < n  && result[i+1][j] == -1) newQueue.add( (i+1) * m + j);
			}
			queue = newQueue;
			++d;
		}
		return result;
	}
}

