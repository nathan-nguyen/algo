class Solution {
    public List<List<String>> findLadders(String bw, String ew, List<String> wl) {
        wl.add(bw);
        int n = wl.size();
        List<List<Integer>> g = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        int end = -1;
        for (int i = 0; i < n; ++i) {
            if (ew.equals(wl.get(i))) end = i;
            g.add(new ArrayList<>());
        }

        if (end == -1) return result;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (check(wl.get(i), wl.get(j))) {
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }

        // BFS
        return result;
    }

    private boolean check(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) ++count;
        }
        return count == 1;
    }

}
