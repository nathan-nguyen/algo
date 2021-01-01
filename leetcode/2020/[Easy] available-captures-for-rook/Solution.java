class Solution {
    public int numRookCaptures(char[][] b) {
        int[] rp = findRook(b);
        int x = rp[0];
        int y = rp[1];
        int count = 0;
        for (int i = x + 1; i < 8; ++i) {
            if (b[i][y] == 'p') {
                ++count;
                break;
            } else if (b[i][y] != '.') break;
        }
        for (int i = x - 1; i >= 0; --i) {
            if (b[i][y] == 'p') {
                ++count;
                break;
            } else if (b[i][y] != '.') break;
        }
        for (int i = y + 1; i < 8; ++i) {
            if (b[x][i] == 'p') {
                ++count;
                break;
            } else if (b[x][i] != '.') break;
        }
        for (int i = y - 1; i >= 0; --i) {
            if (b[x][i] == 'p') {
                ++count;
                break;
            } else if (b[x][i] != '.') break;
        }
        return count;
    }

    private int[] findRook(char[][] b) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (b[i][j] == 'R') return new int[]{i, j};
            }
        }
        return null;
    }
}
