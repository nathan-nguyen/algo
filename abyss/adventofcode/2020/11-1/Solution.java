import java.util.*;

public class Solution {
    private class Wrapper {
        char[][] map;
        int change;

        Wrapper(char[][] map, int change) {
            this.map = map;
            this.change = change;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (in.hasNext()) {
            String s = in.nextLine();
            input.add(s);
        }
        int n = input.size();
        int m = input.get(0).length();

        char[][] map = new char[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) map[i][j] = input.get(i).charAt(j);
        }
        Wrapper wrapper = new Wrapper(map, 0);

        do {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) System.out.print(wrapper.map[i][j]);
                System.out.println();
            }
            wrapper = updateMap(wrapper.map, n, m);
            System.out.println("\nChanges: " + wrapper.change);
        }
        while(wrapper.change > 0);

        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (wrapper.map[i][j] == '#') ++count;
            }
        }
        System.out.println(count);
    }

    private Wrapper updateMap(char[][] map, int n, int m) {
        char[][] next = new char[n][m];
        int change = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int oas = getOccupiedAdjacentSeat(map, n, m, i, j);
                next[i][j] = map[i][j];

                if (map[i][j] == 'L' && oas == 0) {
                    next[i][j] = '#';
                    ++change;
                } else if (map[i][j] == '#' && oas >= 4) {
                    next[i][j] = 'L';
                    ++change;
                }
            }
        }

        return new Wrapper(next, change);
    }

    private int getOccupiedAdjacentSeat(char[][] map, int n, int m, int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (i == 0 && j == 0) continue;
                int nx = x + i;
                int ny = y + j;
                if (nx < 0 || nx >= n) continue;
                if (ny < 0 || ny >= m) continue;
                count += (map[nx][ny] == '#' ? 1 : 0);
            }
        }
        return count;
    }
}
