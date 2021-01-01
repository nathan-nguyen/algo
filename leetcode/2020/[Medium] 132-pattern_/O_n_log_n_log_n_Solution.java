class Solution {
	public boolean find132pattern(int[] nums) {
		if (nums.length == 0) return false;

		int n = nums.length;
		int[] min = new int[n];

		min[0] = nums[0];

		for (int i = 1; i < n; ++i) min[i] = Math.min(nums[i], min[i-1]);

		SegmentTree segmentTree = new SegmentTree(nums, n);

		for (int i = 2; i < n; ++i) {
			int left = 1, right = i-1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (min[mid] >= nums[i]) left = mid + 1;
				else if (segmentTree.query(n, mid, i-1) <= nums[i]) right = mid - 1;
				else return true;
			}
		}

		return false;
	}

	class SegmentTree {
		int st[]; //Array to store segment tree
		int OUT_RANGE_VALUE = Integer.MIN_VALUE;
 
		int function(int x, int y) {
			return (x > y) ? x : y;
		}
 
		int getMid(int s, int e) {
			return s + (e - s) / 2;
		}


		int queryHelper(int ss, int se, int qs, int qe, int index) {
			if (qs <= ss && qe >= se) return st[index]; 
			if (se < qs || ss > qe) return OUT_RANGE_VALUE;
 
			int mid = getMid(ss, se);
			return function(queryHelper(ss, mid, qs, qe, 2 * index + 1), queryHelper(mid + 1, se, qs, qe, 2 * index + 2));
		}
 
		int query(int n, int qs, int qe) {
			if (qs < 0 || qe > n - 1 || qs > qe) {
				System.out.println("Invalid Input");
				return -1;
			}
			return queryHelper(0, n - 1, qs, qe, 0);
		}
 
		int constructHelper(int arr[], int ss, int se, int si){
			if (ss == se) {
				st[si] = arr[ss];
				return arr[ss];
			}
 
			int mid = getMid(ss, se);
			st[si] = function(constructHelper(arr, ss, mid, si * 2 + 1), constructHelper(arr, mid + 1, se, si * 2 + 2));
			return st[si];
		}
 
		SegmentTree(int arr[], int n) {
			int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
 
			int max_size = 2 * (int) Math.pow(2, x) - 1;
			st = new int[max_size]; // Allocate memory
 
			constructHelper(arr, 0, n - 1, 0);
		}
	}

}

