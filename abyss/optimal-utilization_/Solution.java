import java.util.*;

public class Solution {
    private List<List<Integer>> optimalUtilization(int target, List<List<Integer>> a, List<List<Integer>> b) {
        a.sort((u, v) -> Integer.compare(u.get(1), v.get(1)));
        b.sort((u, v) -> Integer.compare(u.get(1), v.get(1)));

        int l = 0;
        int r = b.size() - 1;
        List<List<Integer>> result = new ArrayList<>();
        int max = -1;

        while (l < a.size() && r >= 0) {
            List<Integer> el = a.get(l);
            List<Integer> er = b.get(r);
            if (el.get(1) + er.get(1) > target) {
                --r;
                continue;
            }
            if (el.get(1) + er.get(1) > max) {
                result.clear();
                max = el.get(1) + er.get(1);
            }
            for (int i = r; i >= 0; --i) {
                List<Integer> next = b.get(i);
                if (el.get(1) + next.get(1) == max) {
                    List<Integer> e = new ArrayList<>();
                    e.add(el.get(0));
                    e.add(next.get(0));
                    result.add(e);
                }
            }
            ++l;
        }
        return result;
    }
}
