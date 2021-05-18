import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) ++count[s.charAt(i) - 'a'];

        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int index = c - 'a';

            --count[index];
            if (visited[index]) continue;
            visited[index] = true;

            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                int lastIndex = stack.pop() - 'a';
                visited[lastIndex] = false;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c: stack) sb.append(c);
        return sb.toString();
    }
}
