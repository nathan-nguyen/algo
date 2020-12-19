import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();

        int[][][] top = new int[n][4][t+1];
        int[][][] up = new int[n][4][t+1];
        int[][][] down = new int[n][4][t+1];
        int[][][] bot = new int[n][4][t+1];

        for (int b = 0; b < 4; ++b) bot[0][b][0] = 1;
        for (int a = 1; a < n; ++a) {
            for (int b = 0; b < 4; ++b) {
                for (int i = 0; i < b; ++i) up[a][b][0] += up[a-1][i][0] + bot[a-1][i][0];
            }
        }

        for (int a = 1; a < n; ++a){
            for (int b = 0; b < 4; ++b) {
                for (int c = 1; c <= t; ++c) {
                    for (int i = 0; i < b; ++i) {
                        top[a][b][c] += up[a-1][i][c-1] + bot[a-1][i][c-1];
                        up[a][b][c] += up[a-1][i][c] + bot[a-1][i][c];
                    }
                    for (int i = b + 1; i < 4; ++i) {
                        down[a][b][c] += top[a-1][i][c] + down[a-1][i][c];
                        bot[a][b][c] += top[a-1][i][c] + down[a-1][i][c];
                    }
                }
            }
        }

        System.out.println(down[n-1][0][t] + down[n-1][1][t] + down[n-1][2][t] + down[n-1][3][t]);
    }
}