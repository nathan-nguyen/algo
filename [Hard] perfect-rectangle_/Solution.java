class Solution {
	public boolean isRectangleCover(int[][] r) {
		if (r.length == 0) return true;

		int total = 0;

		int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE, x3 = Integer.MIN_VALUE, y3 = Integer.MIN_VALUE;

		for (int i = 0; i < r.length; ++i){
			x1 = Math.min(x1, r[i][0]);
			y1 = Math.min(y1, r[i][1]);
			x3 = Math.max(x3, r[i][2]);
			y3 = Math.max(y3, r[i][3]);
			total += (r[i][2] - r[i][0]) * (r[i][3] - r[i][1]);
		}

		if (total != (x3 - x1) * (y3 - y1)) return false;

		// Implement second part here!
	}
}
