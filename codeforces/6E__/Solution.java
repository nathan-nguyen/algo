import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; ++i) a[i] = in.nextInt();

		SegmentTree minTree = new SegmentTree(a, n, Integer.MAX_VALUE) {
			@Override
			int function(int x, int y) {
				return (x < y) ? x : y;
			}
		};

		SegmentTree maxTree = new SegmentTree(a, n, Integer.MIN_VALUE) {
                        @Override
                        int function(int x, int y) {
                                return (x > y) ? x : y;
                        }   
                };

		int left = 0, right = 0;
		int max = 1;
		while (left <= right && right < n) {
//			System.out.println(left + " " + right + " " + maxTree.query(n, left, right) + " " + minTree.query(n, left, right));
			if (maxTree.query(n, left, right) - minTree.query(n, left, right) > k) ++left;
			else {
				max = Math.max(max, right - left + 1);
				++right;
			}
		}

		StringBuilder ans = new StringBuilder();
		int count = 0;
		for (int i = 0; i <= n-max; ++i) {
			if (maxTree.query(n, i, i + max - 1) - minTree.query(n, i, i + max - 1) <= k) {
				++count;
				ans.append((i+1) + " " + (i + max) + "\n");
			}
		}
		System.out.println(max + " " + count + "\n" + ans);
	}

	abstract class SegmentTree {
		int st[]; //Array to store segment tree
		int OUT_RANGE_VALUE;

		abstract int function(int x, int y);
 
		int getMid(int s, int e) {
			return s + (e - s) / 2;
		}


		// ss - se - index 
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
 
		SegmentTree(int arr[], int n, int OUT_RANGE_VALUE) {
			int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
 
			int max_size = 2 * (int) Math.pow(2, x) - 1;
			st = new int[max_size]; // Allocate memory

			this.OUT_RANGE_VALUE = OUT_RANGE_VALUE;
			constructHelper(arr, 0, n - 1, 0);
		}
	}
}
