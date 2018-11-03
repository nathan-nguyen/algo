import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private List<List<Integer>> graph = new ArrayList<>();
    private Map<String, int[]> map = new HashMap<>();
    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; ++i) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int max = 0;
        for (int i = 0; i < n; ++i) max = Math.max(max, search(i));

        System.out.println(max);
    }

    private int search(int root) {
        int max = 0;
        List<int[]> result = new ArrayList<>();
        for (int i: graph.get(root)) result.add(traverse(root, i));

        for (int i = 0; i < result.size(); ++i) {
            int localMax = 0;
            for (int j = 0; j < result.size(); ++j) {
                if (j == i) continue;
                localMax = Math.max(localMax, Math.max(result.get(j)[0], result.get(j)[1]));
                for (int k = j + 1; k < result.size(); ++k) {
                    if (k == i) continue;
                    localMax = Math.max(localMax, result.get(j)[0] + result.get(k)[0]);
                }
            }
            max = Math.max(max, result.get(i)[1] * localMax);
        }
        return max;
    }

    private int[] traverse(int parent, int root){
        String key = parent + "_" + root;
        if (map.containsKey(key)) return map.get(key);

        int pass = 1, notPass = 0;
        Queue<int[]> queue = new PriorityQueue<>((u, v) -> Integer.compare(v[0], u[0]));

        for (int i: graph.get(root)) {
            if (i == parent) continue;
            int[] result = traverse(root, i);
            queue.add(result);
            notPass = Math.max(notPass, result[1]);
        }

        if (!queue.isEmpty()) pass = Math.max(pass, queue.peek()[0] + 1);
        if (queue.size() == 1) notPass = Math.max(notPass, queue.peek()[0]);
        else if (queue.size() >= 2) notPass = Math.max(notPass, queue.poll()[0] + queue.peek()[0]);

        int[] finalResult = new int[]{pass, notPass};
        map.put(key, finalResult);
        return finalResult;
    }
}
