import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String s = in.next();
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            int[] count = new int[26];
            int distinct = 0;
            for (int j = i; j < s.length(); ++j) {
                if (count[s.charAt(j) - 'a'] == 0) ++distinct;
                ++count[s.charAt(j) - 'a'];
                if (distinct == k) ++result;
                else if (distinct > k) break;
            }
        }
        System.out.println(result);
    }
}

