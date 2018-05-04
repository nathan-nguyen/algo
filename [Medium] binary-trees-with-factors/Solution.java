class Solution {
	public int numFactoredBinaryTrees(int[] A) {
		int MOD = 1000000007;

		Arrays.sort(A);
		// Value - Index
		HashMap<Integer, Integer> map = new HashMap<>();
		long[] dp = new long[A.length];

		int total = 0;
		for (int i = 0; i < A.length; ++i){
			map.put(A[i], i);
			dp[i] = 1;
			for (int j = 0; j < i && A[j] * A[j] <= A[i]; ++j){
				if (A[i] % A[j] == 0 && map.containsKey(A[i] / A[j])){
					if (A[j] * A[j] == A[i]) dp[i] = (dp[i] + (dp[j] * dp[j]) % MOD) % MOD;
					else dp[i] = (dp[i] + 2 * (dp[j] * dp[map.get(A[i] / A[j])]) % MOD) % MOD;
				}
			}
			total = (total + (int) dp[i]) % MOD;
		}
		return total;
	}
}
