import java.util.*;

public class Solution {
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        int total = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            total += a[i];
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            map.put(a[i], map.get(a[i]) - 1);
            if ((total - a[i]) % 2 == 0 && map.getOrDefault((total - a[i]) / 2, 0) > 0) list.add(i);
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        System.out.println(list.size());

        for (int i : list) System.out.print((i+1) + " ");
    }
}

