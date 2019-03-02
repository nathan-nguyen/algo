class Solution {
    public int[] smallestRange(List<List<Integer>> a) {
        int n = a.size();
        int[] mem = new int[n];
        Set<Integer> set = new HashSet<>();

        List<Integer> all = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int k: a.get(i)) {
                if (map.containsKey(k)) map.get(k).add(i);
                else {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    map.put(k, l);
                    all.add(k);
                }
            }
        }
        Collections.sort(all);

        int start = 0, end = 0;
        int rs = 0, re = Integer.MAX_VALUE;
        while (end < all.size()) {
            int k = all.get(end);
            for (int x: map.get(k)) {
                ++mem[x];
                if (mem[x] == 1) set.add(x);
            }
            while (start <= end && set.size() == n) {
                if (re - rs > all.get(end) - all.get(start)) {
                    rs = all.get(start);
                    re = all.get(end);
                }
                for (int x: map.get(all.get(start))) {
                    --mem[x];
                    if (mem[x] == 0) set.remove(x);
                }
                ++start;
            }
            ++end;
        }
        return new int[]{rs, re};
    }
}
