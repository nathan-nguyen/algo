import java.math.BigInteger;

class Solution {
	public String smallestGoodBase(String n) {
		long maxBase = Long.parseLong(n) - 1;

		if (maxBase == 0) return "10";

		String min = String.valueOf(maxBase);

		// maxBase is always divisible by base
		for (int i = 2; i < 60; ++i){
			int k = (int) Math.pow(maxBase, (double) 1 / i);
			if (k < 2) break;
                        BigInteger left = BigInteger.valueOf(k).pow(i + 1);
                        BigInteger right = BigInteger.valueOf(maxBase + 1).multiply(BigInteger.valueOf(k - 1)).add(BigInteger.valueOf(1));
			if (maxBase % k == 0 && left.equals(right)) min = String.valueOf(k);
		}
		return min;
	}
}

