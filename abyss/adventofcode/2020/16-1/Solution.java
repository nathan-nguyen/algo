import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        StringBuilder nbt = new StringBuilder();
        List<int[]> list = new ArrayList<>();
        int step = 0;

        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println(s);
            if (s.length() == 0) ++step;
            if (step == 0) {
                String[] sp = s.split(": ")[1].split(" or ");
                for (String r: sp) {
                    String[] rs = r.split("-");
                    int[] rse = new int[]{Integer.parseInt(rs[0]), Integer.parseInt(rs[1])};
                    list.add(rse);
                }
            }
            if (s.contains("your ticket:") || s.contains("nearby tickets:")) continue;
            if (step == 2) nbt.append((nbt.length() > 0 ? "," : "") + s);
        }
        System.out.println();

        String[] nt = nbt.toString().split(",");
        int sum = 0;
        for (String nte: nt) {
            int a = Integer.parseInt(nte);
            if (!check(a, list)) sum += a;
        }
        System.out.println(sum);
    }

    private boolean check(int n, List<int[]> list) {
        for (int[] e: list) {
            if (e[0] <= n && n <= e[1]) return true;
        }
        return false;
    }
}
