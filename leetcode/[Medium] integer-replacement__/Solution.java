class Solution {
	public int integerReplacement(int n) {
		if (n == 2147483647) return 32;

		if (n == 1) return 0;

		if (n % 2 == 0) return 1 + integerReplacement(n / 2);

		if (countLastZero(n + 1) < countLastZero(n - 1)) return 1 + integerReplacement(n + 1);
		return 1 + integerReplacement(n - 1);
	}

	private int countLastZero(int n){
		while (n % 2 == 0) n /= 2;

		return n;
	}
}
