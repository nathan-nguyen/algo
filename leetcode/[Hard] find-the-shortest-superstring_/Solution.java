class Solution {
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        // inc[i][j] - Increase length when append A[j] to end of A[i];
        int[][] inc = new int[n][n];
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                inc[i][j] = append(A[i], A[j]);
            }
        }

        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int i = 0; i < (1 << n); ++i) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) dp[1 << i][i] = A[i].length();

        for (int mask = 0; mask < (1 << n); ++mask) {
            for (int i = 0; i < n; ++i) {
                if (((mask >> i) & 1) == 0) continue;
                for (int j = 0; j < n; ++j) {
                    if (((mask >> j) & 1) == 1) continue;
                    int k = mask ^ (1 << j);
                    if (dp[mask][i] + inc[i][j] < dp[k][j]) {
                        dp[k][j] = dp[mask][i] + inc[i][j];
                        parent[k][j] = i;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int track = 0;
        for (int i = 1; i < n; ++i) {
            if (dp[(1 << n) - 1][i] < dp[(1 << n) - 1][track]) track = i;
        }
       
        List<Integer> traceList = new ArrayList<>();
        int prevMask = (1 << n) - 1;
        while (prevMask > 0) {
            traceList.add(track);
            int newLast = parent[prevMask][track];
            prevMask = prevMask ^ (1 << track);
            track = newLast;
        }

        StringBuilder sb = new StringBuilder(A[traceList.get(traceList.size() - 1)]);
        for (int i = traceList.size() - 2; i >= 0; --i) {
            int prev = traceList.get(i + 1);
            int next = traceList.get(i);
            sb.append(A[next].substring(A[next].length() - inc[prev][next]));
        }
        return sb.toString();
    }

    private int append(String s1, String s2) {
        for (int i = Math.min(s1.length(), s2.length()) - 1; i > 0; --i) {
            if (s1.substring(s1.length() - i).equals(s2.substring(0, i))) return s2.length() - i;
        }
        return s2.length();
    }

}
