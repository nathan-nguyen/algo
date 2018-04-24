class Solution {
	public void moveZeroes(int[] a) {
		int n = a.length;
		if (n == 0) return;

		int last = -1;

		for (int i = 0; i < n; ++i){
			if (a[i] == 0) {
				last = i;
				break;
			}
		}

		if (last == -1) return;

		for (int i = last + 1; i < n; ++i){
			if (a[i] != 0){
				a[last++] = a[i];
			}
		}

		for (int i = last; i < n; ++i) a[i] = 0;
	}
}
