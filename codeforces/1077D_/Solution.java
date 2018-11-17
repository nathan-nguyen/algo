import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            int a = in.nextInt();
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // k <= n
        int left = 1, right = n;
        while (left < right) {
            // Care
            int mid = (left + right + 1) / 2;
            if (check(map, mid, k)) left = mid;
            else right = mid - 1;
        }

        List<Integer> list = new ArrayList<>();
        for (int e: map.keySet()) {
            for (int i = 0; list.size() < k && i < map.get(e) / right; ++i) list.add(e);
        }

        for (int e: list) System.out.print(e + " ");
    }

    private boolean check(Map<Integer, Integer> map, int cutTime, int k) {
        int count = 0;
        for (int e : map.keySet()) count += map.get(e) / cutTime;
        return count >= k;
    }
}
