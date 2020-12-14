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

        boolean[] visited = new boolean[pl.size()];
        String t = "shiny gold";
        int tid = getId(t, im, pl);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(tid);
        while (queue.size() > 0) {
            int e = queue.poll();
            if (!visited[e]) {
                visited[e] = true;
                for(int[] pe: pl.get(e)) queue.offer(pe[0]);
            }
        }

        int count = 0;
        for (int i = 0; i < pl.size(); ++i) if (visited[i]) ++count;
        System.out.println(count - 1);
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
            pl.get(cid).add(new int[]{pid, Integer.parseInt(cs[0])});
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
