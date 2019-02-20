import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
        public static void main(String[] args) {
                System.out.println(new Solution().solve());
        }

        private String solve() {
                Scanner in = new Scanner(System.in);
                int n = in.nextInt();
                int m = in.nextInt();

                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < n; ++i) set.add(in.nextInt());

                int count = 0;
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= 1000_000_000; ++i) {
                        if (set.contains(i)) continue;
                        if (m < i) return count + ((sb.length() > 0) ? "\n" + sb.toString().substring(1) : "");
                        ++count;
                        m -= i;
                        sb.append(" " + i);
                }
                return count + ((sb.length() > 0) ? "\n" + sb.toString().substring(1) : "");
        }
}

