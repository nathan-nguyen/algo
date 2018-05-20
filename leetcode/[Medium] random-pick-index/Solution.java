class Solution {
    private HashMap<Integer, List<Integer>> map = new HashMap<>();
    private Random rand = new Random();

    public Solution(int[] nums) {
	for (int i = 0; i < nums.length; ++i){
		if (map.containsKey(nums[i])) {
			map.get(nums[i]).add(i);
			continue;
		}
		else {
			ArrayList<Integer> l = new ArrayList<>();
			l.add(i);
			map.put(nums[i], l);
		}
	}
    }
    
    public int pick(int target) {
	List<Integer> l = map.get(target);
	return l.get(rand.nextInt(l.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
