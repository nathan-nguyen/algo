import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();
        java.util.Arrays.sort(a);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            String key = in.next();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort((u, v) -> Integer.compare(v, u));

        int min = 0, max = 0;
        for (int i = 0; i < list.size(); ++i) {
            min += list.get(i) * a[i];
            max += list.get(i) * a[n - 1 - i];
        }

        System.out.println(min + " " + max);
    }
}
