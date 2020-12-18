import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        long total = 0;
        while (in.hasNextLine()) {
            String s = in.nextLine();
            s = s.replaceAll(" ", "");
            long result = parse(s);
            total += result;
            System.out.println(s + " = " + result);
        }
        System.out.println(total);
    }

    private long parse(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '(') stack.push(new StringBuilder());
            else if (c == ')') {
                String exp = stack.pop().toString();
                long result = calculate(exp);
                stack.peek().append(result);
            } else stack.peek().append(c);
        }
        return calculate(stack.peek().toString());
    }

    private long calculate(String s) {
        System.out.println("Expression: " + s);
        int operatorPosition = -1;
        int mul = s.indexOf("*");
        int add = s.indexOf("+");
        operatorPosition = mul >= 0 ? mul : add;

        if (operatorPosition == -1) return Long.parseLong(s);
        System.out.println("Left: " + s.substring(0, operatorPosition) + " - Right: " + s.substring(operatorPosition + 1));
        long left = calculate(s.substring(0, operatorPosition));
        long right = calculate(s.substring(operatorPosition + 1));
        if (s.charAt(operatorPosition) == '*') return left * right;
        return left + right;
    }
}
