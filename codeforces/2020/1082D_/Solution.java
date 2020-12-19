import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve());
    }

    private String solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] d = new int[n];

        List<Integer> md = new ArrayList<>();
        List<Integer> od = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            d[i] = in.nextInt();
            if (d[i] > 1) md.add(i);
            else od.add(i);
        }

        List<String> edgeList = new ArrayList<>();
        for (int i = 1; i < md.size(); ++i) {
            int u = md.get(i-1);
            int v = md.get(i);
            addList(edgeList, u, v);
            --d[u];
            --d[v];
        }

        if (od.size() > 0) {
            int count = 0;
            for (int i = 1; i < od.size(); ++i) {
                while (count < md.size() && d[md.get(count)] == 0) ++count;
                if (count >= md.size()) return "NO";

                int k = md.get(count);
                --d[k];
                addList(edgeList, od.get(i), k);
            }

            while (count < md.size() && d[md.get(count)] == 0) ++count;
            if (count >= md.size()) return "NO";

            int k = md.get(md.size() - 1);
            --d[k];
            addList(edgeList, od.get(0), k);
        }

        StringBuilder result = new StringBuilder();
        appendLine(result, "YES " + (md.size() - 1 + Math.min(od.size(), 2)));
        appendLine(result, String.valueOf(edgeList.size()));
        for (String s: edgeList) appendLine(result, s);
        return result.toString(); 
    }

    private void appendLine(StringBuilder sb, String s) {
        sb.append(s);
        sb.append('\n');
    }

    private void addList(List<String> list, int i, int j) {
        list.add((i + 1) + " " + (j + 1));
    }
}
