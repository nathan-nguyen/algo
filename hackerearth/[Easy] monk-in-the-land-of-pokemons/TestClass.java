import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t -- > 0) {
            int n = in.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            int result = 0;
            for (int i = 0; i < n; ++i) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                map.put(a, map.getOrDefault(a, 0) + 1);
                if (map.getOrDefault(b, 0) > 0) map.put(b, map.get(b) - 1);
                else ++result;
            }
            System.out.println(result);
        }
    }
}

