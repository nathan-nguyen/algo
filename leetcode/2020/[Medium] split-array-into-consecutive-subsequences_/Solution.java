class Solution {
    public boolean isPossible(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int k: a) map.put(k, map.getOrDefault(k, 0) + 1);

        Map<Integer, Integer> endMap = new HashMap<>();
        for (int k: a) {
            while (map.get(k) > 0) {
                if (endMap.getOrDefault(k - 1, 0) > 0) {
                    map.put(k, map.get(k) - 1);
                    endMap.put(k - 1, endMap.get(k - 1) - 1);
                    endMap.put(k, endMap.getOrDefault(k, 0) + 1);
                }
                else if (map.getOrDefault(k + 1, 0) > 0 && map.getOrDefault(k + 2, 0) > 0) {
                    map.put(k, map.get(k) - 1);
                    map.put(k + 1, map.get(k + 1) - 1);
                    map.put(k + 2, map.get(k + 2) - 1);
                    endMap.put(k + 2, endMap.getOrDefault(k + 2, 0) + 1);
                }
                else return false;
            }
        }
        return true;
    }

}
