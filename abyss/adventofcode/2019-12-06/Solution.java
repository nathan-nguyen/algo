import java.util.*;

public class Solution {
    private Scanner in = new Scanner(System.in);
    private Map<String, List<String>> g = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();        
    }

    private void solve() {
        while (in.hasNext()) {
            String[] s = in.next().split("\\)");
            put(s[0], s[1], g);
            put(s[1], s[0], g);
        }
        System.out.println(dfs("YOU", g, 0, new HashSet<>()) - 2);
    }

    private void put(String key, String value, Map<String, List<String>> g) {
        List<String> list = g.getOrDefault(key, new ArrayList<>());
        list.add(value);
        g.put(key, list);
    }
    private int dfs(String node, Map<String, List<String>> g, int cost, Set<String> visited) {
        if (visited.contains(node)) return Integer.MAX_VALUE;
        visited.add(node);

        if (node.equals("SAN")) return cost;
        if (!g.containsKey(node)) return Integer.MAX_VALUE;

        for (String s: g.get(node)) {
            int value = dfs(s, g, cost + 1, visited);
            if (value != Integer.MAX_VALUE) return value;
        }
        return Integer.MAX_VALUE;
    }
}
