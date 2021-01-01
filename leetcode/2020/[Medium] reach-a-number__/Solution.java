class Solution {
	public int reachNumber(int target) {
		long newTarget = Math.abs((long) target);
		int n = (int) Math.sqrt(2 * newTarget);
		long max = ((long) n * n + n) / 2;
		if (newTarget == max) return n;
		if (max < newTarget) {
			++n;
			max = ((long) n * n + n) / 2;
		}

		if ((max - newTarget) % 2 == 0) return n;
		else {
			return (max + n + 1 - newTarget) % 2 == 0 ? n + 1 : n + 2;
		}
	}
}
