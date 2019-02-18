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
        long sum = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) list.add(in.nextInt());
        Collections.sort(list);

        for (int i = 0; i < n; ++i) sum += Math.abs(list.get(i) - i - 1);
        System.out.println(sum);
    }
}
