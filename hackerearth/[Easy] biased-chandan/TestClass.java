import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            int a = in.nextInt();
            if (a == 0 && stack.size() > 0) stack.pop();
            else stack.push(a);
        }
        int sum = 0;
        for (int i: stack) sum += i;
        System.out.println(sum);
    }
}

