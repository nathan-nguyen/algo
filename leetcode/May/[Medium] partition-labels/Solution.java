import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) ++count[s.charAt(i) - 'a'];

        List<Integer> result = new ArrayList<>();

        int start = 0, end = 0, total = 0;
        boolean[] visited = new boolean[26];

        while (start < s.length() && end < s.length()) {
            int index = s.charAt(end) - 'a';

            if (!visited[index]) total += count[index];

            --total;
            visited[index] = true;
            ++end;

            if (total == 0) {
                result.add(end - start);
                start = end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
