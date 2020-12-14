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
        int dx = 10, dy = 1;

        while (in.hasNext()) {
            String s = in.next();
            char code = s.charAt(0);
            int number = Integer.parseInt(s.substring(1));
            if (code == 'N') dy += number;
            else if (code == 'S') dy -= number;
            else if (code == 'E') dx += number;
            else if (code == 'W') dx -= number;
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

    private int[] left(int x, int y) {
        int ndx = 0, ndy = 0;
        int dx = x / Math.abs(x);
        int dy = y / Math.abs(y);

        if (dx == 1 && dy == 1) {
            ndx = -1;
            ndy = 1;
        } else if (dx == -1 && dy == 1) {
            ndx = -1;
            ndy = -1;
        } else if (dx == -1 && dy == -1) {
            ndx = 1;
            ndy = -1;
        } else if (dx == 1 && dy == -1) {
            ndx = 1;
            ndy = 1;
        }
        return new int[]{ndx * Math.abs(y), ndy * Math.abs(x)};
    }
}
