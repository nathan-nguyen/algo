class Solution {
    public int maxWidthRamp(int[] a) {
        if (a.length == 0) return 0;
        int n = a.length;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) if (stack.isEmpty() || a[stack.peek()] > a[i]) stack.push(i);

        int max = 0;
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty()) {
                if (a[i] < a[stack.peek()]) break;
                max = Math.max(max, i - stack.pop());
            }
            if (stack.isEmpty()) break;
        }
        return max;
    }
}

