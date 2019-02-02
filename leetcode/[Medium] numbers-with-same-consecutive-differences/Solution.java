class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < 10; ++i) {
            for (int s: numsSameConsecDiff(n, k, i, map)) result.add(s);
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) answer[i] = result.get(i);
        return answer;
    }

    private List<Integer> numsSameConsecDiff(int n, int k, int x, Map<Integer, List<Integer>> map) {
        List<Integer> result = new ArrayList<>();
        if (x > 9 || x < 0) return result;
        int key = n * 10 + x;
        if (map.containsKey(key)) return map.get(key);
        if (n == 1) result.add(x);
        else {
            for (int s: numsSameConsecDiff(n - 1, k, x + k, map)) result.add(x * (int) Math.pow(10, n - 1) + s);
            if (k > 0) for (int s: numsSameConsecDiff(n - 1, k , x - k, map)) result.add(x * (int) Math.pow(10, n - 1) + s);
        }
        map.put(key, result);
        return result;
    }
}
