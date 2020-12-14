import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int dx = 1, dy = 0;

        while (in.hasNext()) {
            String s = in.next();
            char code = s.charAt(0);
            int number = Integer.parseInt(s.substring(1));
            if (code == 'N') y += number;
            else if (code == 'S') y -= number;
            else if (code == 'E') x += number;
            else if (code == 'W') x -= number;
            else if (code == 'L') {
                number = number % 360;
                while (number > 0) {
                    int[] nd = left(dx, dy);
                    dx = nd[0];
                    dy = nd[1];
                    number -= 90;
                }
            } else if (code == 'R') {
                number = 360 - number % 360;
                while (number > 0) {
                    int[] nd = left(dx, dy);
                    dx = nd[0];
                    dy = nd[1];
                    number -= 90;
                }
            } else if (code == 'F') {
                x += dx * number;
                y += dy * number;
            }
            System.out.println(s + " " + x + " " + y);
        }
        System.out.println(Math.abs(x) + Math.abs(y));
    }

    private int[] left(int dx, int dy) {
        int ndx = 0, ndy = 0;
        if (dx == 0 && dy == 1) {
            ndx = -1;
            ndy = 0;
        } else if (dx == -1 && dy == 0) {
            ndx = 0;
            ndy = -1;
        } else if (dx == 0 && dy == -1) {
            ndx = 1;
            ndy = 0;
        } else if (dx == 1 && dy == 0) {
            ndx = 0;
            ndy = 1;
        }
        return new int[]{ndx, ndy};
    }
}
