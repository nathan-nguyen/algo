// Classic way

Arrays.sort(points, new Comparator<int[]>(){
	@Override public int compare(int[] o1, int[] o2){
		// Convert to (long) to avoid overflow
		if (o1[0] == o2[0]) return 0;
		return (o1[0] > o2[0]) ? 1 : -1;
	}
});

// In Java 8

Integer[] a = new Integer[100];
int[] condition = new int[100];

Arrays.sort(a, (x, y) -> condition[x] - condition[y]);

// Primitive type cannot be sorted this way, need to convert to Object

int[][] a = new int[100][2];

Arrays.sort(a, (x, y) -> x[0] - y[0]);

Arrays.sort(a, (x, y) -> {
	if (x[0] == y[0]) return x[1] - y[1];
	else return x[0] - y[0];
});

--------------------

for (int key : frequencyMap.keySet()) {
	int frequency = frequencyMap.get(key);
	if (bucket[frequency] == null) {
		bucket[frequency] = new ArrayList<>();
	}
	bucket[frequency].add(key);
}

--------------------

public int searchInsert(int[] A, int target) {
	int low = 0, high = A.length-1;
	while(low<=high){
		int mid = (low+high)/2;
		if(A[mid] == target) return mid;
		else if(A[mid] > target) high = mid-1;
		else low = mid+1;
	}
	return low;
}

--------------------

PriorityQueue<Integer> pq = new PriorityQueue<>();
for (int i = 0; i < nums.length; ++i){
	pq.offer(nums[i]);
	if (pq.size() > k) pq.poll();
}
return pq.peek();

--------------------

// String - REGEX match
int matches = (password.matches(".*[0-9].*")? 0 : 1) + (password.matches(".*[a-z].*") ? 0 : 1) + (password.matches(".*[A-Z].*") ? 0 : 1) + (password.matches(".*[!@#$%^&*()-+].*") ? 0 : 1);

--------------------

ArrayList<Integer> result = new ArrayList<>();
int[] resultArray = result.stream().mapToInt(i->i).toArray();

--------------------

Arrays.copyOfRange

--------------------

ListNode cur = head;
ListNode next = head;

while(next != null && next.next != null){
	cur = cur.next;
	next = next.next.next;
}

// 2: 0-1-null		-> 0-0|1-null
// 3: 0-1-2-null	-> 0-0|1-2
// 4: 0-1-2-3-null	-> 0-0|1-2|2-null

--------------------

Flip bit at poition k

n ^ (1 << k)

--------------------

abstract class SegmentTree {
	int st[]; //Array to store segment tree
	int OUT_RANGE_VALUE = Integer.MAX_VALUE;	// Min
	int OUT_RANGE_VALUE = Integer.MIN_VALUE;	// Max
	int OUT_RANGE_VALUE = 0;			// Sum
 
	abstract int function(int x, int y);
	int function(int x, int y) {return (x < y) ? x : y;}	// Min
	int function(int x, int y) {return (x > y) ? x : y;}	// Max
	int function(int x, int y) {return x + y;}		// Sum
 
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

	int updateHelper(int ss, int se, int si, int i, int newVal) {
		if (i < ss || i > se) return st[si];
 
		if (se != ss) {
			int mid = getMid(ss, se);
			st[si] = function(updateHelper(ss, mid, 2 * si + 1, i, newVal), updateHelper(mid + 1, se, 2 * si + 2, i, newVal));
		}
		else st[si] = newVal;
		return st[si];
	}
 
	void update(int arr[], int n, int i, int newVal){
		if (i < 0 || i > n - 1) {
			System.out.println("Invalid Input");
			return;
		}
 
 		arr[i] = newVal;
		updateHelper(0, n - 1, 0, i, newVal);
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

--------------------

