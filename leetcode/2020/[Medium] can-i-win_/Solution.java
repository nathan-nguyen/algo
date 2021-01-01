class Solution {
    public boolean canIWin(int n, int total) {
        if (n >= total) return true;
        if (n * (n + 1) / 2 < total) return n % 2 == 0;
        return dfs(n, 0, total, new HashMap<>());
    }

    private boolean dfs(int n, int k, int desiredTotal, HashMap<Integer, Boolean> map) {
        if (map.containsKey(k)) return map.get(k);

        int total = 0;
        for (int i = 0; i < n; ++i) {
            if (((k >>i) & 1) == 1) total += (i + 1);
        }
        
        if (total >= desiredTotal) return false;
        boolean found = true;
        for (int i = 0; i < n; ++i) {
            if (((k >> i) & 1) == 1) continue;
            found = found && dfs(n, (k | (1 << i)), desiredTotal, map);
        }
        map.put(k, !found);
        return !found;
    }

}

