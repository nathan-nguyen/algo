class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            int index = i, count = 0, previousIndex = -1;
            while (nums[index] != -1) {
                ++count;
                previousIndex = index;
                index = nums[index];
                nums[previousIndex] = -1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
