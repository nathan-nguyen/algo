import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        List<String> ticketList = new ArrayList<>();
        int step = 0;

        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println(s);
            if (s.length() == 0) {
               ++step;
               continue;
            }
            if (step == 0) {
                String[] sp = s.split(": ")[1].split(" or ");
                int[] range = new int[4];
                int count = 0;
                for (String r: sp) {
                    String[] rs = r.split("-");
                    range[count++] = Integer.parseInt(rs[0]);
                    range[count++] = Integer.parseInt(rs[1]);
                }
                list.add(range);
            }
            if (s.contains("your ticket:") || s.contains("nearby tickets:")) continue;
            if (step >= 1) ticketList.add(s);
        }
        System.out.println();

        System.out.println(ticketList);
        List<List<Integer>> vtl = new ArrayList<>();
        outter: for(String ticket: ticketList) {
            String[] ts = ticket.split(",");
            List<Integer> tk = new ArrayList<>();
            for (String tse: ts) {
                int number = Integer.parseInt(tse);
                if (check(number, list)) tk.add(number);
                else continue outter;
            }
            vtl.add(tk);
        }
        System.out.println(vtl + " - Size: " + vtl.size());

        int n = list.size();
        List<List<Integer>> vcl = new ArrayList<>();
        boolean[][] checkMap = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            int[] range = list.get(i);
            List<Integer> validColumn = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if(checkValid(range, vtl, j)) validColumn.add(j);
            }
            vcl.add(validColumn);
        }
        System.out.println(vcl);

        // Occupied column
        boolean[] visited = new boolean[n];
        Stack<int[]> stack = new Stack<>();
        backTrack(vcl, 0, visited, stack);

        long result = 1L;
        for (int i = 0; i < 6; ++i) {
            int[] e = stack.get(i);
            System.out.println(e[0] + " " + e[1] + " " + vtl.get(0).get(e[1]));
            result *= vtl.get(0).get(e[1]);
        }
        System.out.println(result);
    }

    private boolean check(int n, List<int[]> list) {
        for (int[] e: list) {
            if ((e[0] <= n && n <= e[1]) || (e[2] <= n && n <= e[3])) return true;
        }
        return false;
    }

    // Whether criteria statisfying column
    private boolean checkValid(int[] c, List<List<Integer>> vtl, int cid) {
        for (List<Integer> list: vtl) {
            int n = list.get(cid);
            if (!((c[0] <= n && n <= c[1]) || (c[2] <= n && n <= c[3]))) return false;
        }
        return true;
    }

    private boolean backTrack(List<List<Integer>> vcl, int i, boolean[] visited, Stack<int[]> stack) {
        if (i == vcl.size()) return true;
        for (int k: vcl.get(i)) {
            if (visited[k]) continue;
            visited[k] = true;
            stack.push(new int[]{i, k});
            boolean result = backTrack(vcl, i + 1, visited, stack);
            if (result) return result;
            stack.pop();
            visited[k] = false;
        }
        return false;
    }
}
