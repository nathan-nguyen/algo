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
            if (set.contains(2020 - a)) {
                System.out.println(a * (2020 - a));
                return;
            }
            set.add(a);
        }
    }
}
