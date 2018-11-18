import java.io.*;
import java.util.*;

public class Solution {

    private String solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        List<List<int[]>> edge = new ArrayList<>(); 
        for (int i = 0; i < n; ++i) edge.add(new ArrayList<>());

        while (m -- > 0) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int c = in.nextInt();
            edge.get(a).add(new int[]{b, c});
            edge.get(b).add(new int[]{a, c});
            String k1 = a + "_" + b;
            String k2 = b + "_" + a;
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        Queue<int[]> queue = new PriorityQueue<>((u, v) -> Integer.compare(u[1], v[1]));
        queue.offer(new int[]{0, cost[0]});

        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            int[] e = queue.poll();
            int index = e[0];
            int c = e[1];
            if (visited[index]) continue;
            visited[index] = true;
            cost[index] = c;
            if (index == n - 1) return String.valueOf(cost[index]);

            for (int[] connection: edge.get(index)) {
                int next = connection[0];
                if (cost[next] > Math.max(cost[index], connection[1])) {
                    cost[next] = Math.max(cost[index], connection[1]);
                    queue.offer(new int[]{next, cost[next]});
                }
            }
        }

        return cost[n-1] == Integer.MAX_VALUE ? "NO PATH EXISTS" : String.valueOf(cost[n-1]);
    }

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
 
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve());
        solution.exit();
    }

    private void exit() {
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }

}
