class Solution {
    public int leastOpsExpressTarget(int n, int k, Set<Integer> set, Map<Integer, Integer> map) {
        if (map.containsKey(k)) return map.get(k);

        // Maximum valid result can be 4 * 10 ^ 8
        int result = 1000_000_000;
        if (set.contains(k)) return result;
        set.add(k);

        int x = (int) (Math.log(k) / Math.log(n));
        if ((int) Math.pow(n, x) == k) {
            map.put(k, x);
            return x;
        }

        int greater = (int) Math.pow(n, x + 1) - k;
        int smaller = k - (int) Math.pow(n, x);

        // Always process the smaller number first
        if (greater < smaller) {
            result = Math.min(x + 1 + leastOpsExpressTarget(n, greater, set, map), (x == 0 ? 2 : x) + leastOpsExpressTarget(n, smaller, set, map));
        } else {
            result = Math.min((x == 0 ? 2 : x) + leastOpsExpressTarget(n, smaller, set, map), x + 1 + leastOpsExpressTarget(n, greater, set, map));
        }
        map.put(k, result);
        return result;
    }

    public int leastOpsExpressTarget(int n, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        return leastOpsExpressTarget(n, k, set, map) - 1;
    }
}


