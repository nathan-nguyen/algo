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
        List<Integer> input = new ArrayList<>();
        input.add(0);
        while (in.hasNext()) {
            int a = in.nextInt();
            input.add(a);
        }
        Collections.sort(input);
        int one = 0;
        int three = 1;
        for (int i = 1; i < input.size(); ++i) {
            int cur = input.get(i);
            int prev = input.get(i - 1);
            if (cur - prev == 1) ++one;
            else if (cur - prev == 3) ++three;
        }
        System.out.println(one + " " + three + " " + (one * three));
    }
}
