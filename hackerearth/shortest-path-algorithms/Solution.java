import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve());
    }

    private int solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt() - 1;
        int e = in.nextInt() - 1;

        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) list.add(new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int c = in.nextInt();
            map.put(a + "_" + b, c);
            list.get(a).add(b);
        }

        
        int[][] edge = new int[n][n];
        for (int i = 0; i < n; ++i) edge[i] = shortestPath(i, map, list, n);

        if (edge[s][e] == Integer.MAX_VALUE || edge[e][s] == Integer.MAX_VALUE) return -1;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (edge[i][j] == Integer.MAX_VALUE || edge[j][i] == Integer.MAX_VALUE) {
                    map.remove(i + "_" + j);
                    map.remove(j + "_" + i);
                } else {
                    if (map.containsKey(i + "_" + j)) map.put(i + "_" + j, map.get(i + "_" + j) + edge[j][i]);
                    if (map.containsKey(j + "_" + i)) map.put(j + "_" + i, map.get(j + "_" + i) + edge[i][j]);
                }
            }
        }
//        System.out.println(map);
        return shortestPath(s, map, list, n)[e];
    }

    private int[] shortestPath(int s, Map<String, Integer> map, List<List<Integer>> list, int n) {
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<int[]> queue = new PriorityQueue<>((u, v) -> Integer.compare(u[1], v[1]));
        queue.add(new int[]{s, 0});
        while (!queue.isEmpty()) {
            int[] k = queue.poll();
            int index = k[0];
            int d = k[1];
            if (visited[index]) continue;
            visited[index] = true;
            distance[index] = d;
//            System.out.println(s + " " + index + " " + d);

            for (int next: list.get(index)) {
                if (!map.containsKey(index + "_" + next)) continue;
                int edge = map.get(index + "_" + next);
                if (distance[next] > distance[index] + edge) {
                    distance[next] = distance[index] + edge;
                    queue.offer(new int[]{next, distance[next]});
                }
            }
        }
        return distance;
    }
}

