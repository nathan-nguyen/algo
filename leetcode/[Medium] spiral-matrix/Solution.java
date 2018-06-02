class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        	int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;

		List<Integer> result = new ArrayList<>();
		while (left <= right && up <= down){
			for (int i = left; i <= right; ++i) result.add(matrix[up][i]);
			for (int i = up + 1; i <= down; ++i) result.add(matrix[i][right]);
			for (int i = right - 1; up != down && i >= left; --i) result.add(matrix[down][i]);
			for (int i = down - 1; left != right && i >= up + 1; --i) result.add(matrix[i][left]);
			++left;	--right;
			++up;	--down;
		}
		return result;
	}
}
