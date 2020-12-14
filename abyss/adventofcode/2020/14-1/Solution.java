import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        Map<Integer, Long> map = new HashMap<>();
 
        String mask = "";
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.contains("mask")) mask = s.substring(7);
            else {
                String[] sp = s.split(" = ");
                int left = Integer.parseInt(sp[0].substring(4, sp[0].length() - 1));
                int right = Integer.parseInt(sp[1]);
                map.put(left, getMask(right, mask));
            }
        }
        long total = 0;
        for (int key: map.keySet()) total += map.get(key);
        System.out.println(total);
    }

    private long getMask(long n, String s) {
        long allOne = (1L << 36) - 1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') n |= (1L << (35 - i));
            else if (s.charAt(i) == '0') n &= (allOne ^ (1L << (35 - i)));
        }
        return n;
    }
}
