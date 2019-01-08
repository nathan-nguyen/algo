import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() throws Exception {
        MinStack minStack = new MinStack();
        minStack.printPush(20);
        minStack.printPush(10);
        minStack.printPush(9);
        minStack.printPop();
        minStack.printPush(20);
        minStack.printPush(5);
        minStack.printPop();
        minStack.printPush(3);
        minStack.printPush(8);
        minStack.printPop();
        minStack.printPop();
        minStack.printPush(2);
        minStack.printPop();
    }

    class MinStack {
        private Stack<Integer> stack = new Stack<>();
        private static final int MAX_VALUE = 1 << 29;
        private int min = MAX_VALUE;

        private void push(int n) throws Exception {
            if (n >= MAX_VALUE) throw new Exception("Push value must be less than MAX_VALUE");

            if (n >= min) stack.push(n);
            else {
                stack.push(2 * n - min);
                min = n;
            }
        }

        private int pop() throws Exception {
            if (stack.size() == 0) throw new Exception("Stack is empty");

            if (stack.peek() < min) {
                min = 2 * min - stack.peek();
                return (min + stack.pop()) / 2;
            }
            return stack.pop();
        }

        private int getMin() {
            if (stack.size() == 0) System.out.println("Stack is empty!");
            return min;
        }

        private void printPush(int n) throws Exception {
            push(n);
            System.out.println("Pushed " + n + " - Min: " + getMin());
        }

        private void printPop() throws Exception {
            System.out.println("Pop " + pop() + " - Min: " + getMin());
        }
    }
}
