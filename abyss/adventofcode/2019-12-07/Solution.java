import java.util.*;

public class Solution {
    private Scanner in = new Scanner(System.in);
    private String[] token;

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() throws Exception {
        String s = in.next();
        this.token = s.split(",");

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < 5; ++i) max = Math.max(max, dfs(i, 0, new Stack<>(), 0));
        System.out.println(max);
    }

    private int dfs(int node, int visited, Stack<Integer> stack, int max) throws Exception {
        if (((visited >> node) & 1) == 1) return max;
        stack.push(node);
        visited = visited | (1 << node);
        if (visited == 31) {
            System.out.println(stack);
            int lastResult = 0;
            Amplifier[] aList = new Amplifier[5];
            for (int i = 0; i < 5; ++i) aList[i] = new Amplifier(stack.get(i) + 5);
            int finalResult = 0;
            try {
                for (int i = 0; i < Integer.MAX_VALUE; ++i) {
                    System.out.println(lastResult + " " + i % 5);
                    lastResult = aList[i % 5].run(lastResult);
                    if (i % 5 == 4) finalResult = lastResult;
                }
            } catch(Exception e) {
                // e.printStackTrace();
            }
            max = Math.max(max, finalResult);
        }
        else {
            for (int i = 0; i < 5; ++i) max = dfs(i, visited, stack, max);
        }
        stack.pop();
        return max;
    }

    class Amplifier {
        private int config;
        private int inputCount;
        private int[] a = new int[1000];

        private int p = 0;

        Amplifier(int config) {
            this.config = config;
            for (int i = 0; i < token.length; ++i) a[i] = Integer.parseInt(token[i]);
        }

        private int run(int lastResult) throws Exception {
            while (p < a.length) {
                int number = a[p];
                int code = a[p] % 100;
                int[] mode = new int[3];
                mode[0] = (number / 100) % 10;
                mode[1] = (number / 1000) % 10;
                mode[2] = (number / 10000) % 10;

                // System.out.println("[Amplifier] " + p + " " + number);
                if (code == 99) throw new Exception("Exit code 99");
                if (code == 1) {
                    if (mode[2] == 0) a[a[p+3]] = (mode[0] == 0 ? a[a[p+1]] : a[p+1]) + (mode[1] == 0 ? a[a[p+2]] : a[p+2]);
                    else System.out.println("Error 1");
                    p += 4;
                }
                else if (code == 2) {
                    if (mode[2] == 0) a[a[p+3]] = (mode[0] == 0 ? a[a[p+1]] : a[p+1]) * (mode[1] == 0 ? a[a[p+2]] : a[p+2]);
                    else System.out.println("Error 2");
                    p += 4;
                }
                else if (code == 3) {
                    if (mode[0] != 0) System.out.println("Error 3");
                    if (inputCount == 0) a[a[p + 1]] = config;
                    else a[a[p + 1]] = lastResult;
                    ++inputCount;
                    p += 2;
                }
                else if (code == 4) {
                    int result = mode[0] == 0 ? a[a[p+1]] : a[p+1];
                    // System.out.println(result);
                    p += 2;
                    return result;
                }
                else if (code == 5) {
                    if ((mode[0] == 0 ? a[a[p+1]] : a[p+1]) != 0) p = (mode[1] == 0 ? a[a[p+2]] : a[p+2]);
                    else p += 3;
                }
                else if (code == 6) {
                    if ((mode[0] == 0 ? a[a[p+1]] : a[p+1]) == 0) p = (mode[1] == 0 ? a[a[p+2]] : a[p+2]);
                    else p += 3;
                }
                else if (code == 7) {
                    int first = mode[0] == 0 ? a[a[p+1]] : a[p+1];
                    int second = mode[1] == 0 ? a[a[p+2]] : a[p+2];
                    if (mode[2] == 0) a[a[p+3]] = (first < second) ? 1 : 0;
                    else System.out.println("Error 7");
                    p += 4;
                }
                else if (code == 8) {
                    int first = mode[0] == 0 ? a[a[p+1]] : a[p+1];
                    int second = mode[1] == 0 ? a[a[p+2]] : a[p+2];
                    if (mode[2] == 0) a[a[p+3]] = (first == second) ? 1 : 0;
                    else System.out.println("Error 8");
                    p += 4;
                }
                else throw new Exception("Invalid instruction code: " + number);
            }
            throw new Exception("Invalid code flow");
        }
    }
}
