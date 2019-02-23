class Solution {
    public double[] calcEquation(String[][] e, double[] v, String[][] q) {
        int n = v.length;
        double[] result = new double[q.length];

        Set<String> zero = new HashSet<>();
        Map<String, List<String>> g = new HashMap<>();
        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String a = e[i][0];
            String b = e[i][1];
            if (v[i] == 0) {
                zero.add(a);
                continue;
            }

            List<String> al = g.getOrDefault(a, new ArrayList<>());
            List<String> bl = g.getOrDefault(b, new ArrayList<>());
            al.add(b);
            bl.add(a);
            g.put(a, al);
            g.put(b, bl);
            map.put(a + "_" + b, v[i]);
            map.put(b + "_" + a, 1 / v[i]);
        }

        for (int i = 0; i < q.length; ++i) {
            String start = q[i][0];
            String end = q[i][1];
            if (zero.contains(start)) result[i] = 0;
            else result[i] = dfs(start, end, g, map, new HashSet<>());
        }
        return result;
    }

    private static final List<String> EMPTY_LIST = new ArrayList<>();

    private double dfs(String cur, String end, Map<String, List<String>> g, Map<String, Double> map, Set<String> set) {
        if (!g.containsKey(cur) || set.contains(cur)) return -1;
        if (cur.equals(end)) return 1;
        set.add(cur);
        for (String next: g.getOrDefault(cur, EMPTY_LIST)) {
            double result = dfs(next, end, g, map, set);
            if (result != -1) return map.get(cur + "_" + next) * result;
        }
        set.remove(cur);
        return -1;
    }
}
