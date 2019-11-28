import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        Map<String, List<Integer>> map = new HashMap<>();
        int n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            String s = in.next();
            List<Integer> list = map.getOrDefault(s, new ArrayList<>());
            list.add(i);
            map.put(s, list);
        }

        int q = in.nextInt();
        for (int i = 0; i < q; ++i) 
    }
}
