import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private static final int[] CENTER = new int[]{1000, 1000};

    private void solve() {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        while (in.hasNext()) {
            String s = in.next();
            int p = getPosition(flip(s, CENTER));;
            if (set.contains(p)) set.remove(p);
            else set.add(p);
        }
        for (int i = 0; i < 100; ++i) set = process(set);
        System.out.println(set.size());
    }

    private Set<Integer> process(Set<Integer> set) {
        Set<Integer> next = new HashSet<>();
        Set<Integer> process = new HashSet<>();
        for (int p: set) {
            List<Integer> neighborList = getNeighborList(p);
            process.add(p);
            process.addAll(neighborList);
        }

        for (int p: process) {
            int btc = countBlackTitles(set, p);
            if (set.contains(p) && btc > 0 && btc <= 2) next.add(p);
            if (!set.contains(p) && btc == 2) next.add(p);
        }
        return next;
    }

    private int getPosition(int[] p) {
        return p[0] * 10000 + p[1];
    }

    private int[] getCoordinate(int p) {
        return new int[]{p / 10000, p % 10000};
    }

    private List<Integer> getNeighborList(int p) {
        int[] currentPosition = getCoordinate(p);
        List<Integer> result = new ArrayList<>();
        result.add(getPosition(flip("ne", currentPosition)));
        result.add(getPosition(move('e', currentPosition[0], currentPosition[1], 2)));
        result.add(getPosition(flip("se", currentPosition)));
        result.add(getPosition(flip("sw", currentPosition)));
        result.add(getPosition(move('w', currentPosition[0], currentPosition[1], 2)));
        result.add(getPosition(flip("nw", currentPosition)));
        return result;
    }

    private int countBlackTitles(Set<Integer> set, int p) {
        List<Integer> neighborList = getNeighborList(p);
        int count = 0;
        for (int e: neighborList) {
            if (set.contains(e)) ++count;
        }
        return count;
    }

    private int[] move(char c, int x, int y, int step) {
        switch (c) {
            case 'n': y += step; break;
            case 'e': x += step; break;
            case 's': y -= step; break;
            case 'w': x -= step; break;
        }
        return new int[]{x, y};
    }

    private int[] flip(String s, int[] p) {
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'w' || c == 'e') p = move(c, p[0], p[1], 2);
            else {
                p = move(c, p[0], p[1], 1);
                ++i;
                c = s.charAt(i);
                p = move(c, p[0], p[1], 1);
            }
        }
        return p;
    }
}
