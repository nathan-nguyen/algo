class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        	int[][] a = new int[nums.length][2];

		for (int i = 0; i < nums.length; ++i){
			a[i][0] = nums[i];
			a[i][1] = i;
		}

		Arrays.sort(a, new Comparator<int[]>(){
			@Override public int compare(int[] o1, int[] o2){
				// Convert to (long) to avoid overflow
				if (o1[0] == o2[0]) return Double.compare(o1[1], o2[1]);
				return Double.compare(o1[0], o2[0]);
			}
		});


		for (int i = 0; i < nums.length; ++i){
			for (int j = i - 1; j >= 0 && Math.abs((long)a[i][0] - a[j][0]) <= t; --j){
				if (Math.abs(a[i][1] - a[j][1]) <= k) return true;
			}
			for (int j = i + 1; j < nums.length && Math.abs((long)a[i][0] -  a[j][0]) <= t; ++j){
                                if (Math.abs(a[i][1] - a[j][1]) <= k) return true;
                        }
		}
		return false;
	}
}
