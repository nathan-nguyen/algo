class Solution {
    public boolean canReorderDoubled(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i: a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            list.add(i);
        }
        list.sort((u, v) -> Math.abs(u) - Math.abs(v));
        int count = 0;
        for (int i = 0; i < a.length; ++i) {
            int k = list.get(i);
            if (map.get(k) == 0 || map.getOrDefault(2 * k, 0) == 0) continue;
            map.put(k, map.get(k) - 1);
            map.put(2 * k, map.get(2 * k) - 1);
            ++count;
        }
        return count == a.length / 2;
    }
}

