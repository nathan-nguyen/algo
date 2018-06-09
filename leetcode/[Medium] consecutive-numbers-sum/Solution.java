class Solution {
	public int consecutiveNumbersSum(int N) {
		if (N <= 0) return 0;

		int count = 0;

		long sum = 0;
		int n = 1;

		while (sum < N) {
			if ((N - sum) % n == 0) ++count;
			sum += (n++);
		}
	
		return count;	
        }
}
