class Solution {
    public int[] gridIllumination(int n, int[][] l, int[][] q) {
        Set<String> set = new HashSet<>();
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        Map<Integer, Integer> y_xMap = new HashMap<>();
        Map<Integer, Integer> x_yMap = new HashMap<>();

        for (int[] a: l) {
            addLamp(set, a[0], a[1], xMap, yMap, y_xMap, x_yMap);
        }

        int[] result = new int[q.length];
        for (int i = 0; i < q.length; ++i) result[i] = check(set, q[i][0], q[i][1], xMap, yMap, y_xMap, x_yMap);
        return result;
    }

    private int check(Set<String> set, int x, int y, Map<Integer, Integer> xMap, Map<Integer, Integer> yMap, Map<Integer, Integer> y_xMap, Map<Integer, Integer> x_yMap) {
        boolean result = xMap.getOrDefault(x, 0) > 0 || yMap.getOrDefault(y, 0) > 0 || y_xMap.getOrDefault(y - x, 0) > 0 || x_yMap.getOrDefault(x + y, 0) > 0;
        if (result) {
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) removeLamp(set, x + i, y + j, xMap, yMap, y_xMap, x_yMap);
            }
        }
        return result ? 1 : 0;
    }

    private void addLamp(Set<String> set, int x, int y, Map<Integer, Integer> xMap, Map<Integer, Integer> yMap, Map<Integer, Integer> y_xMap, Map<Integer, Integer> x_yMap) {
        set.add(x + "_" + y);
        addMap(x, xMap);
        addMap(y, yMap);
        addMap(y - x, y_xMap);
        addMap(x + y, x_yMap);
    }

    private void removeLamp(Set<String> set, int x, int y, Map<Integer, Integer> xMap, Map<Integer, Integer> yMap, Map<Integer, Integer> y_xMap, Map<Integer, Integer> x_yMap) {
        if (!set.contains(x + "_" + y)) return;
        set.remove(x + "_" + y);
        removeMap(x, xMap);
        removeMap(y, yMap);
        removeMap(y - x, y_xMap);
        removeMap(x + y, x_yMap);
    }

    private void addMap(int val, Map<Integer, Integer> map) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    private void removeMap(int val, Map<Integer, Integer> map) {
        map.put(val, map.get(val) - 1);
    }
}
