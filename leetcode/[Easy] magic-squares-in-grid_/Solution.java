class Solution {
	public int numMagicSquaresInside(int[][] a) {
        	if (a.length == 0 || a[0].length == 0 ) return 0;

		int n = a.length;
		int m = a[0].length;

		int count = 0;
		for (int i = 0; i < n - 2; ++i){
			for (int j = 0; j < m - 2; ++j){
				if (a[i+1][j+1] != 5) continue;
				if (verify(a[i][j], a[i][j+1], a[i][j+2], a[i+1][j], a[i+1][j+1], a[i+1][j+2], a[i+2][j], a[i+2][j+1], a[i+2][j+2])) ++count;
			}
		}
		return count;
	}

	private boolean verify(int... v){
		boolean[] uniq = new boolean[10];
		for (int i: v){
			if (i < 1 || i > 9 || uniq[i]) return false;
			uniq[i] = true;
		}

		return (v[0] + v[1] + v[2] == 15 &&
			v[3] + v[4] + v[5] == 15 &&
			v[6] + v[7] + v[8] == 15 &&

			v[0] + v[3] + v[6] == 15 &&
			v[1] + v[4] + v[7] == 15 &&
			v[2] + v[5] + v[8] == 15 &&
			v[0] + v[4] + v[8] == 15 &&
			v[2] + v[4] + v[6] == 15);
	}
}
