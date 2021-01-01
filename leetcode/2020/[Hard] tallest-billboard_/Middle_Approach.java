class Solution {
    public int tallestBillboard(int[] a) {
        if (a.length == 0) return 0;
        int n = a.length;

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for (int i = 0; i < n / 2; ++i) l1.add(a[i]);
        for (int i = n / 2; i < n; ++i) l2.add(a[i]);
        Map<Integer, Integer> m1 = combine(l1);
        Map<Integer, Integer> m2 = combine(l2);

        int max = 0;
        for (int k: m1.keySet()) {
            if (m2.containsKey(-k)) max = Math.max(max, m1.get(k) + m2.get(-k));
        }
        return max;
    }

    private Map<Integer, Integer> combine(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int a: list) {
            Map<Integer, Integer> curMap = new HashMap<>(map);
            for (int k: curMap.keySet()) {
                map.put(k + a, Math.max(curMap.get(k) + a, map.getOrDefault(k + a, 0)));
                map.put(k - a, Math.max(curMap.get(k), map.getOrDefault(k - a, 0)));
            }
        }
        return map;
    }
}
