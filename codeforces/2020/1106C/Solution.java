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

        // There might be some TLE test cases for quicksort in Java, so dont use Arrays.sort
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) list.add(in.nextInt());
        Collections.sort(list);

        long result = 0;
        for (int i = 0; i < n / 2; ++i) result += (list.get(i) + list.get(n - 1 - i)) * (list.get(i) + list.get(n - 1 - i));
        System.out.println(result);
    }
}
