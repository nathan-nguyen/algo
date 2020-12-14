import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            input.add(s);
        }
        int n = input.size();
        int m = input.get(0).length();

        int count = 0;
        for (int i = 0, j = 0; i < n; i+=1, j+=3) {
            if (input.get(i).charAt(j % m) != '.') ++count;
        }
        System.out.println(count);
    }
}
