import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        Map<Long, Integer> map = new HashMap<>();
 
        String mask = "";
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.contains("mask")) mask = s.substring(7);
            else {
                String[] sp = s.split(" = ");
                int left = Integer.parseInt(sp[0].substring(4, sp[0].length() - 1));
                int right = Integer.parseInt(sp[1]);
                List<Long> al = getMask(left, mask);
                for (long a: al) map.put(a, right);
            }
        }
        System.out.println(map);
        long total = 0;
        for (long key: map.keySet()) total += map.get(key);
        System.out.println(total);
    }

    private List<Long> getMask(long n, String s) {
        long allOne = (1L << 36) - 1;

        List<Long> result = new ArrayList<>();
        result.add(0L);
        for (int i = 0; i < s.length(); ++i) {
            List<Long> next = new ArrayList<>();
            if (s.charAt(i) == '0') {
                for (long a: result) next.add(a * 2 + ((n >> (35 - i)) & 1));
            } else if (s.charAt(i) == '1') {
                for (long a: result) next.add(a * 2 + 1);
            } else if (s.charAt(i) == 'X') {
                for (long a: result) {
                    next.add(a * 2);
                    next.add(a * 2 + 1);
                }
            }
            result = next;
        }
        return result;
    }
}
