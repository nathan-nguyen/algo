class Solution {

class SegmentTree {
	int[][] st; //Array to store segment tree
	int[] OUT_RANGE_VALUE = new int[]{Integer.MAX_VALUE, -1};
 
	int[] function(int[] x, int[] y) {
		return (x[0] < y[0]) ? x : y;
	}
 
	int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

	// ss - se - index 
	int[] queryHelper(int ss, int se, int qs, int qe, int index) {
		if (qs <= ss && qe >= se) return st[index];
 
		if (se < qs || ss > qe) return OUT_RANGE_VALUE;
 
		int mid = getMid(ss, se);
		return function(queryHelper(ss, mid, qs, qe, 2 * index + 1), queryHelper(mid + 1, se, qs, qe, 2 * index + 2));
	}
 
	int[] query(int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1 || qs > qe) {
			System.out.println("Invalid Input");
			return OUT_RANGE_VALUE;
		}
 
		return queryHelper(0, n - 1, qs, qe, 0);
	}

	int[] constructHelper(int arr[][], int ss, int se, int si){
		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}
 
		int mid = getMid(ss, se);
		st[si] = function(constructHelper(arr, ss, mid, si * 2 + 1), constructHelper(arr, mid + 1, se, si * 2 + 2));
		return st[si];
	}
 
	SegmentTree(int arr[][], int n) {
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
 
		int max_size = 2 * (int) Math.pow(2, x) - 1;
		st = new int[max_size][2]; // Allocate memory
 
		constructHelper(arr, 0, n - 1, 0);
	}
}

	public int largestRectangleArea(int[] h) {
		if (h.length == 0) return 0;

		int[][] arr = new int[h.length][2];
		for (int i = 0; i < h.length; ++i) {
			arr[i][0] = h[i];
			arr[i][1] = i;
		}

		SegmentTree st = new SegmentTree(arr, h.length);
		return findMax(st, 0, h.length - 1, h.length, arr);
	}

	private int findMax(SegmentTree st, int start, int end, int n, int[][] arr){
		if (start < 0 || start > end || end >= n) return 0;
		if (start == end) return arr[start][0];

		int[] val = st.query(n, start, end);

		if (val[1] == -1) return 0;
		int lmax = Math.max(findMax(st, start, val[1] - 1, n, arr), findMax(st, val[1] + 1, end, n, arr));
		return Math.max(val[0] * (end - start + 1), lmax);
	}
}
