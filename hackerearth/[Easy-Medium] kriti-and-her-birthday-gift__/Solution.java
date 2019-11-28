import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String s = in.next();
            List<Integer> list = map.getOrDefault(s, new ArrayList<>());
            list.add(i);
            map.put(s, list);
        }

        int q = in.nextInt();
        for (int i = 0; i < q; ++i) {
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;
            String k = in.next();
            List<Integer> list = map.getOrDefault(k, new ArrayList<>());
            int li = Collections.binarySearch(list, l);
            li = (li < 0) ? -li - 1 : li;
            int ri = Collections.binarySearch(list, r);
            ri = (ri < 0) ? -ri - 2 : ri;
            System.out.println(ri - li + 1);
        } 
    }
}
