import java.util.Scanner;

public class Solution {
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() throws Exception {
        String s = in.next();
        String[] token = s.split(",");

        solve(token);
    }

    private void solve(String[] token) throws Exception {
        int[] a = new int[1000];
        for (int i = 0; i < token.length; ++i) a[i] = Integer.parseInt(token[i]);

        int p = 0;
        while (p < a.length) {
            int number = a[p];
            int code = a[p] % 100;
            int[] mode = new int[3];
            mode[0] = (number / 100) % 10;
            mode[1] = (number / 1000) % 10;
            mode[2] = (number / 10000) % 10;

            // System.out.println(p + " " + number);
            if (code == 99) break;
            if (code == 1) {
                if (mode[2] == 0) a[a[p+3]] = (mode[0] == 0 ? a[a[p+1]] : a[p+1]) + (mode[1] == 0 ? a[a[p+2]] : a[p+2]);
                else System.out.println("Error 1");
                p += 4;
            }
            else if (code == 2) {
                if (mode[2] == 0) a[a[p+3]] = (mode[0] == 0 ? a[a[p+1]] : a[p+1]) * (mode[1] == 0 ? a[a[p+2]] : a[p+2]);
                else System.out.println("Error 2");
                p += 4;
            }
            else if (code == 3) {
                if (mode[0] != 0) System.out.println("Error 3");
                a[a[p + 1]] = in.nextInt();
                p += 2;
            }
            else if (code == 4) {
                System.out.println(mode[0] == 0 ? a[a[p+1]] : a[p+1]);
                p += 2;
            }
            else if (code == 5) {
                if ((mode[0] == 0 ? a[a[p+1]] : a[p+1]) != 0) p = (mode[1] == 0 ? a[a[p+2]] : a[p+2]);
                else p += 3;
            }
            else if (code == 6) {
                if ((mode[0] == 0 ? a[a[p+1]] : a[p+1]) == 0) p = (mode[1] == 0 ? a[a[p+2]] : a[p+2]);
                else p += 3;
            }
            else if (code == 7) {
                int first = mode[0] == 0 ? a[a[p+1]] : a[p+1];
                int second = mode[1] == 0 ? a[a[p+2]] : a[p+2];
                if (mode[2] == 0) a[a[p+3]] = (first < second) ? 1 : 0;
                else System.out.println("Error 7");
                p += 4;
            }
            else if (code == 8) {
                int first = mode[0] == 0 ? a[a[p+1]] : a[p+1];
                int second = mode[1] == 0 ? a[a[p+2]] : a[p+2];
                if (mode[2] == 0) a[a[p+3]] = (first == second) ? 1 : 0;
                else System.out.println("Error 8");
                p += 4;
            }
            else throw new Exception("Invalid instruction code: " + number);
        }
    }
}
