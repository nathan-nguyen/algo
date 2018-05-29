class NumArray {
	private int[] bit;
	private int[] nums;
	private int n;

 	public NumArray(int[] nums) {
		this.nums = nums;
		this.n = nums.length;
		this.bit = new int[n + 1];

		for (int i = 0; i < n; ++i) update(i, nums[i]);
	}
    
 	public void update(int i, int val) {
		val = val - sumRange(i, i);
		int k = i + 1;
		while (k <= n) {
			bit[k] += val;
			k += k & (-k);
		} 
	}
    
	private int sumRange(int i){
		int sum = 0;
		int k = i + 1;

		while (k > 0){
			sum += bit[k];
			k -= k & (-k);
		}
		return sum;
	}

	public int sumRange(int i, int j) {
		if (i == 0) return sumRange(j);
		return sumRange(j) - sumRange(i - 1);
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
