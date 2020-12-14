import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        while (in.hasNext()) {
            int a = in.nextInt();
            for (int b: set) {
                int c = 2020 - a - b;
                if (set.contains(c)) {
                    System.out.println((long)a * b * c);
                    return;
                }
            }
            set.add(a);
        }
    }
}
