class Solution {
    public int findJudge(int n, int[][] t) {
        int[] count = new int[n+1];
   
        boolean[][] m = new boolean[n+1][n+1];
        for (int[] a: t) m[a[0]][a[1]] = true;

        int found = -1;
        outer:for (int i = 1; i <= n; ++i) {
            boolean trust = true;
            for (int j = 1; j <= n; ++j) {
                if (m[i][j]) continue outer;
                if (i == j) continue;
                trust = trust && m[j][i];
            }
            if (trust && !m[i][i]) {
                if (found != -1) return -1;
                found = i;
            }
        }
        return found;
    }
}
