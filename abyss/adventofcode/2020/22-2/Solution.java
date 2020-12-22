import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        StringBuilder sb = sb1;
        while (in.hasNext()) {
            String s = in.nextLine();
            if (s.length() == 0) {
                sb = sb2;
                continue;
            }
            else if (s.contains("Player")) continue;
            sb.append(String.format("%02d", Integer.parseInt(s)));
        }
        System.out.println(sb1.toString() + " " + sb2.toString());

        String result = play(sb1.toString(), sb2.toString()).replaceAll("-", "");
        long total = 0;
        System.out.println("Winner: " + result);
        for (int i = 0; i < result.length() / 2; ++i) {
            total += Integer.parseInt(result.substring(2 * i, 2 * i + 2)) * (result.length() / 2 - i);
        }
        System.out.println(total);
    }

    // Return the winner
    private String play(String s1, String s2) {
        Set<String> previousState = new HashSet<>();
        while (s1.length() > 0 && s2.length() > 0) {
            String state = s1 + "-" + s2;

            if (previousState.contains(state)) return s1;
            else previousState.add(state);

            int n1 = Integer.parseInt(s1.substring(0, 2));
            int n2 = Integer.parseInt(s2.substring(0, 2));
            String[] next;
            if (n1 > s1.length() / 2 - 1 || n2 > s2.length() / 2 - 1) {
                next = update(s1, s2, n1, n2, n1 > n2);
            } else {
                // Sub-game
                String s1sub = s1.substring(2, 2 + 2 * n1);
                String s2sub = s2.substring(2, 2 + 2 * n2);
                String result = play(s1sub, s2sub);
                next = update(s1, s2, n1, n2, !result.contains("-"));
            }
            s1 = next[0];
            s2 = next[1];      
        }

        String winner = s1.length() == 0 ? ("-" + s2) : s1;
        return winner;
    }

    private String[] update(String s1, String s2, int n1, int n2, boolean oneWin) {
        if (oneWin) return new String[]{
            s1.substring(2) + String.format("%02d%02d", n1, n2),
            s2.substring(2)
        };
        return new String[]{
            s1.substring(2),
            s2.substring(2) + String.format("%02d%02d", n2, n1)
        };
    }
}
