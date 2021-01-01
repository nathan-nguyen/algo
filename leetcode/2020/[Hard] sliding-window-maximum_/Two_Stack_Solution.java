class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) return new int[0];
        Stack<int[]> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k - 1; ++i) push(in, nums[i]);
        for (int i = k - 1; i < nums.length; ++i) {
            push(in, nums[i]);
            result[i - k + 1] = peek(in, out);
            pop(in, out, k);
        }
        return result;
    }

    private void push(Stack<int[]> in, int value) {
        int top = in.isEmpty() ? value : in.peek()[1];
        in.push(new int[]{value, Math.max(top, value)});
    }

    private void pop(Stack<int[]> in, Stack<Integer> out, int k) {
        if (out.isEmpty()) {
            while (!in.isEmpty() || out.size() < k) {
                int[] value = in.pop();
                if (out.isEmpty()) out.push(value[0]);
                else out.push(Math.max(value[0], out.peek()));
            }
        }
        out.pop();
    }

    private int peek(Stack<int[]> in, Stack<Integer> out) {
        int inTop = in.isEmpty() ? Integer.MIN_VALUE : in.peek()[1];
        int outTop = out.isEmpty() ? Integer.MIN_VALUE : out.peek();
        return Math.max(inTop, outTop);
    }
}
