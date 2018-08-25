class Solution {
	public int maxRotateFunction(int[] A) {
		if (A.length == 0) return 0;
		
		int sum = 0;
		int result = 0;
		for (int i = 0; i < A.length; ++i) {
			sum += A[i];
			result += i * A[i];
		}

		int max = result;
		for (int i = 1; i < A.length; ++i) {
			result = result + A.length * A[i - 1] - sum;
			max = Math.max(max, result);
		}

		return max;
	}
}
