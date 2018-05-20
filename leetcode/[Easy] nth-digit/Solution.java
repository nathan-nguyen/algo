class Solution {
	// n > 0
	public int findNthDigit(int n) {
		int min  = 1;
		int max = min * 10 - 1;
		int digit = 1;
		long totalDigit = digit * (max - min + 1);

		while (n > totalDigit){
			++digit;

			min = max + 1;
			max = min * 10 - 1;

			totalDigit += (long)digit * (max - min + 1);
		}

		long left = totalDigit - n;

		int k = max - (int)(left / digit);

		for (int i = 0; i < left % digit; ++i) k /= 10;

		return k % 10;
	}
}
