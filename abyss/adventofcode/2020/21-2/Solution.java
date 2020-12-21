import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    class Rule {
        Set<Integer> left;
        Set<Integer> right;
        Rule(String s, Map<String, Integer> lm, Map<String, Integer> rm, List<String> ingredientList, List<String> al) {
           String[] sp = s.split(" \\(contains ");
           String[] ra = sp[1].substring(0, sp[1].length() - 1).split(", ");
           right = new HashSet<>();
           for (String e: ra) right.add(getId(e, rm, al));

           left = new HashSet<>();
           String[] la = sp[0].split(" ");
           for (String e: la) left.add(getId(e, lm, ingredientList));
           System.out.println(left + " " + right);
        }
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        List<Rule> rl = new ArrayList<>();
        Map<String, Integer> lm = new HashMap<>();
        Map<String, Integer> rm = new HashMap<>();
        List<String> ingredientList = new ArrayList<>();
        List<String> al = new ArrayList<>();

        while (in.hasNext()) rl.add(new Rule(in.nextLine(), lm, rm, ingredientList, al));
        int n = lm.size();
        int m = rm.size();
        
        int[][] map = new int[n][m];
        int[] rowZero = new int[n];
        int[] columnZero = new int[m];
        Arrays.fill(rowZero, m);
        Arrays.fill(columnZero, n);

        printMap(map, n, m);
        for (Rule rule: rl) {
            for (int j: rule.right) {
                for (int i = 0; i < n; ++i) {
                    if (!rule.left.contains(i)) {
                        if (map[i][j] != 0) continue;
                        map[i][j] = -1;
                        --rowZero[i];
                        --columnZero[j];
                    }
                }
            }
        }
        printMap(map, n, m);

        reduce(map, n, m, rowZero, columnZero);
        List<String[]> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (map[i][j] == 1) {
                    result.add(new String[]{ingredientList.get(i), al.get(j)});
                    break;
                }
            }
        }
        Collections.sort(result, (u, v) -> u[1].compareTo(v[1]));
        StringBuilder sb = new StringBuilder();
        for (String[] e: result) sb.append(e[0] + ",");
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private void reduce(int[][] map, int n, int m, int[] rowZero, int[] columnZero) {
        int change = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (map[i][j] == 0 && (rowZero[i] == 1 || columnZero[j] == 1)) {
                    ++change;
                    update(map, n, m, rowZero, columnZero, i, j);
                }
            }
        }
        System.out.println("Change: " + change);
        printMap(map, n, m);
        if (change > 0) reduce(map, n, m, rowZero, columnZero);
    }

    private void update(int[][] map, int n, int m, int[] rowZero, int[] columnZero, int x, int y) {
        map[x][y] = 1;
        --rowZero[x];
        --columnZero[y];
        for (int i = 0; i < n; ++i) {
            if (map[i][y] != 0) continue;
            map[i][y] = -1;
            --rowZero[i];
            --columnZero[y];
        }

        for (int i = 0; i < m; ++i) {
            if (map[x][i] != 0) continue;
            map[x][i] = -1;
            --rowZero[x];
            --columnZero[i];
        }
    }

    private void printMap(int[][] map, int n, int m) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) System.out.print(map[i][j] == -1 ? " -1 " : ("  " + map[i][j] + " "));
            System.out.println();
        }
        System.out.println();
    }

    private int getId(String s, Map<String, Integer> map, List<String> ingredientList) {
        if (map.containsKey(s)) return map.get(s);
        int id = map.size(); 
        map.put(s, id);
        ingredientList.add(s);
        return id;
    }
}
