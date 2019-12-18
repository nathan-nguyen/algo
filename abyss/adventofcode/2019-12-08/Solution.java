import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(s.length());
        int[] image = new int[150];
        Arrays.fill(image, 2);

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (image[i % 150] == 2 && c != '2') image[i % 150] = c == '0' ? 0 : 1;
        }
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 25; ++j) System.out.print(image[i * 25 + j]);
            System.out.println();
        }
        int countOne = 0, countTwo = 0;
        for (int i = 0; i < 150; ++i) {
            if (image[i] == 1) ++countOne;
            else if (image[i] == 2) ++countTwo;
        }
        System.out.println(countOne * countTwo);
    }
}
