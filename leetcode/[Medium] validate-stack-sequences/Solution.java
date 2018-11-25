class Solution {
    public boolean validateStackSequences(int[] push, int[] pop) {
        if (push.length == 0) return true;
        int n = push.length;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (int num: push) {
            stack.push(num);
            while (stack.size() > 0 && pop[i] == stack.peek()) {
                stack.pop();
                ++i;
            }
        }
        return stack.isEmpty();
    }
}

