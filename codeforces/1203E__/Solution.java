import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(in.nextInt());
        Collections.sort(a);
        int min = 0, count = 0;
        for (int i: a) {
            if (i - 1 > min) {
                min = i - 1;
                ++count;
            }
            else if (i > min) {
                min = i;
                ++count;
            }
            else if (i + 1 > min) {
                min = i + 1;
                ++count;
            }
        }
        System.out.println(count);
    }
}
