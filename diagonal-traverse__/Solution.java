class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
	int M = matrix.length;
	int N = matrix[0].length;

	int[] result = new int[N * M];
	int count = 0;
	boolean reverse = true;

	for (int k = 0; k < N + M - 1; ++k){
		int i = 0, j = k;
		if (k >= N) {
			i = k - (N - 1);
			j = N - 1;
		}

		int[] tmp = new int[Math.min(N, M)];
		int local = 0;

		while (0 <= i && 0 <= j && i < M && j < N){
			tmp[local++] = matrix[i++][j--];
		}

		if (reverse) for (int u = local - 1; u >= 0; --u) result[count++] = tmp[u];
		else for (int u = 0; u < local; ++u) result[count++] = tmp[u];

		reverse = !reverse;
	}

	return result; 
    }
}

