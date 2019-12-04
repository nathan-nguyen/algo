import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        String love = "love";
        String s = in.next();
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (count == 4) break;
            if (s.charAt(i) == love.charAt(count)) ++count;
        }
        System.out.println(count == 4 ? "I love you, too!" : "Let us breakup!");
    }
}

