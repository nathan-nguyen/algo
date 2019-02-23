class Solution {
    public boolean equationsPossible(String[] equations) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < 26; ++i) g.add(new ArrayList<>());
        int[] group = new int[26];

        for (String s: equations) {
            if (s.charAt(1) == '!') continue;
            int first = s.charAt(0) - 'a';
            int second = s.charAt(3) - 'a';

            g.get(first).add(second);
            g.get(second).add(first);
        }

        for (int i = 0; i < 26; ++i) {
            if (group[i] != 0) continue;
            dfs(i, g, group, i + 1);
        }

        for (String s: equations) {
            if (s.charAt(1) == '=') continue;
            int first = s.charAt(0) - 'a';
            int second = s.charAt(3) - 'a';
            if (group[first] == group[second] && group[first] > 0) return false;
        }
        return true;
    }

    private void dfs(int i, List<List<Integer>> g, int[] group, int cur) {
        if (group[i] != 0) return;
        group[i] = cur;
        for (int k: g.get(i)) dfs(k, g, group, cur);
    }
}
