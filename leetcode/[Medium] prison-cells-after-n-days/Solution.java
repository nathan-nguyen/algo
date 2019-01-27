class Solution {
    public int[] prisonAfterNDays(int[] c, int n) {
        int k = 0;
        for (int i = 0; i < 8; ++i) {
            if (c[i] == 1) k |= (1 << i);
        }

        List<Integer> order = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        order.add(k);
        map.put(k, 0);
        for (int j = 1; j <= n; ++j) {
            int next = 0;
            for (int i = 1; i < 7; ++i) {
                if (((k >> (i-1)) & 1) == ((k >> (i+1)) & 1)) next |= (1 << i);
            }
            if (map.containsKey(next)) {
                int x = j - map.get(next);
                int position = (n - j) % x + map.get(next);
                k = order.get(position);
                break;
            }
            k = next;
            order.add(k);
            map.put(k, j);
        }

        for (int i = 0; i < 8; ++i) {
            if (((k >> i) & 1) == 1) c[i] = 1;
            else c[i] = 0;
        }
        return c;
    }
}

