import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> im = new HashMap<>();
        List<List<int[]>> pl = new ArrayList<>();
        while(in.hasNextLine()) {
            String s = in.nextLine();
            parseInput(s, im, pl);
        }

        String t = "shiny gold";
        int tid = getId(t, im, pl);

        int[] c = new int[pl.size()];
        System.out.println(im);
        System.out.println(dfs(tid, pl, c) - 1);
    }

    private int dfs(int i, List<List<int[]>> pl, int[] c) {
        if (c[i] > 0) return c[i];
        c[i] = 1;
        for (int[] e: pl.get(i)) c[i] += e[1] * dfs(e[0], pl, c);
        System.out.println(i + " " + c[i]);
        return c[i];
    }

    private void parseInput(String s, Map<String, Integer> im, List<List<int[]>> pl) {
        if (s.contains("no other bags")) return;

        String[] sp = s.split(" ");
        String p = sp[0] + " " + sp[1];
        int pid = getId(p, im, pl);
        System.out.println(p + " " + pid);
        String ci = s.substring(14 + p.length());

        String[] ce = ci.split(", ");
        for (String c: ce) {
            String[] cs = c.split(" ");
            String cn = cs[1] + " " + cs[2];
            int cid = getId(cn, im, pl);
            pl.get(pid).add(new int[]{cid, Integer.parseInt(cs[0])});
        }
    }

    private int getId(String s, Map<String, Integer> im, List<List<int[]>> pl) {
        if (im.containsKey(s)) return im.get(s);
        int id = im.keySet().size();
        im.put(s, id);
        pl.add(new ArrayList<>());
        return id;
    }
}
