class Solution {
	public int numFriendRequests(int[] ages) {
		int[] a = new int[121];

		for (int i : ages) ++a[i];

		int count = 0;
		for (int i = 1; i < 121; ++i){
			if (a[i] == 0) continue;
			for (int j = 1; j <= i; ++j){
				if (2 * j - 14 <= i) continue;
				if (i > j) count += a[i] * a[j];
				else count += a[i] * (a[i] - 1);
			}
		}
		return count;
	}
}
