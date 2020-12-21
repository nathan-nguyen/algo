import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    // [3][20]
    private static String[] MONSTER = new String[]{
        "                  # ",
        "#    ##    ##    ###",
        " #  #  #  #  #  #   "
    };

    class Square {
        int id;
        int[] side;
        int flip;
        int rotate;
        String[] input;
        Square(String[] input, int id, int[] original, int flip, int rotate) {
            this.input = input;
            this.id = id;
            this.side = rotateSquare(flipSquare(original, flip), rotate);
            this.flip = flip;
            this.rotate = rotate;
        }

        char[][] getOutput() {
            int n = input.length - 2;
            char[][] source = new char[n][n];
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) source[i-1][j-1] = input[i].charAt(j);
            }
            return rotateArray(flipArray(source, flip), rotate);
        } 
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        String[] input = null;
        int row = 0, id = 0;
        List<Square> squareList = new ArrayList<>();

        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.length() == 0) {
                int[] a = convertInput(input);
                squareList.add(new Square(input, id, a, 0, 0));
                squareList.add(new Square(input, id, a, 0, 1));
                squareList.add(new Square(input, id, a, 0, 2));
                squareList.add(new Square(input, id, a, 0, 3));

                squareList.add(new Square(input, id, a, 1, 0));
                squareList.add(new Square(input, id, a, 1, 1));
                squareList.add(new Square(input, id, a, 1, 2));
                squareList.add(new Square(input, id, a, 1, 3));
                continue;
            }

            if (s.contains("Tile")) {
                id = Integer.parseInt(s.substring(5, s.length() - 1));
                input = new String[10];
                row = 0;
            }
            else input[row++] = s;
        }

        Map<Integer, List<Square>>[] map = new HashMap[4];
        for (int i = 0; i < 4; ++i) {
            map[i] = new HashMap<>();
            for (Square square: squareList) {
                List<Square> list;
                if (!map[i].containsKey(square.side[i])) {
                    list = new ArrayList<>();
                    map[i].put(square.side[i], list);
                }
                else list = map[i].get(square.side[i]);
                list.add(square);
            }
        }

        int total = squareList.size() / 8;
        int n = (int) Math.sqrt(total);
        Stack<Square> stack = backtrack(squareList, map);
        char[][] result = new char[8 * n][8 * n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Square sq = stack.get(i * n + j);
                char[][] source = sq.getOutput();
                for (int x = 0; x < 8; ++x) {
                    for (int y = 0; y < 8; ++y) result[8 * i + x][8 * j + y] = source[x][y];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 8 * n; ++i) {
            for (int j = 0; j < 8 * n; ++j) {
                if (result[i][j] == '#') ++count;
            }
        }
    
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 4; ++j) {
                char[][] transform = rotateArray(flipArray(result, i), j);
                int k = getMonsterCount(result, 8 * n);
                if (k > 0) {
                    System.out.println("Found " + k + " monster(s)!");
                    System.out.println(count - k * 15);
                    return;
                }
            }
        }
    }

    private int getMonsterCount(char[][] result, int n) {
        int total = 0;
        for (int i = 0; i < n - 3; ++i) {
            for (int j = 0; j < n - 20; ++j) total += getMonsterCount(result, i, j);
        }
        return total;
    }

    private int getMonsterCount(char[][] result, int x, int y) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 20; ++j) {
                if (MONSTER[i].charAt(j) == '#' && result[x + i][y + j] != '#') return 0;
            }
        }
        return 1;
    }

    private int[] rotateSquare(int[] a, int t) {
        while (t -- > 0) {
            int[] b = new int[4];
            b[0] = flip(a[3]);
            b[1] = a[0];
            b[2] = flip(a[1]);
            b[3] = a[2];
            a = b;
        }
        return a;
    }

    private int[] flipSquare(int[] a, int t) {
        while (t -- > 0) {
            int[] b = new int[4];
            b[0] = flip(a[0]);
            b[1] = a[3];
            b[2] = flip(a[2]);
            b[3] = a[1];
            a = b;
        }
        return a;
    }

    private int flip(int a) {
        int result = 0;
        for (int i = 0; i < 10; ++i) {
            if (((a >> i) & 1) == 1) result |= 1 << (9 - i);
        }
        return result;
    }

    private int[] convertInput(String[] input) {
        int one = convertBorder(input[0]);
        int three = convertBorder(input[9]);
        StringBuilder two = new StringBuilder();
        StringBuilder four = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            two.append(input[i].charAt(9));
            four.append(input[i].charAt(0));
        }
        return new int[]{one, convertBorder(two.toString()), three, convertBorder(four.toString())};
    }

    private int convertBorder(String s) {
        int result = 0;
        for (int i = 0; i < 10; ++i) {
            if (s.charAt(i) == '#') result |= 1 << (9 - i);
        }
        System.out.println(s + " - Result: " + result + " - Flip: " + flip(result));
        return result;
    }

    private Stack<Square> backtrack(List<Square> squareList, Map<Integer, List<Square>>[] map) {
        int total = squareList.size() / 8;
        int n = (int) Math.sqrt(total);
        Stack<Square> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for (Square square: squareList) {
            stack.push(square);
            visited.add(square.id);
            if (backtrack(stack, map, visited, n)) {
                for (Square e: stack) System.out.println(e.id);
                break;
            }
            visited.remove(square.id);
            stack.pop();
        }
        return stack;
    }

    private boolean backtrack(Stack<Square> stack, Map<Integer, List<Square>>[] map, Set<Integer> visited, int n) {
        if (stack.size() == n * n) return true;
        int x = stack.size() % n;
        int y = stack.size() / n;
        Square up = null, left = null;
        List<Square> nextList = null;
        if (x > 0) {
            left = stack.get(stack.size() - 1);
            if (map[3].containsKey(left.side[1])) nextList = map[3].get(left.side[1]);
        }
        if (y > 0) {
            up = stack.get(stack.size() - n);
            if (nextList == null && map[0].containsKey(up.side[2])) nextList = map[0].get(up.side[2]);
        }
        if (nextList == null) return false;
        for (Square square: nextList) {
            if (visited.contains(square.id)) continue;
            if (up != null && up.side[2] != square.side[0]) continue;
            if (left != null && left.side[1] != square.side[3]) continue;
            stack.push(square);
            visited.add(square.id);
            if (backtrack(stack, map, visited, n)) return true;
            stack.pop();
            visited.remove(square.id);
        }
        return false; 
    }

    private char[][] flipArray(char[][] a, int t) {
        int n = a.length;
        while (t -- > 0) {
            char[][] b = new char[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) b[i][n-1-j] = a[i][j];
            }
            a = b;
        }
        return a;
    }

    private char[][] rotateArray(char[][] a, int t) {
        int n = a.length;
        while (t -- > 0) {
            char[][] b = new char[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) b[j][n-1-i] = a[i][j];
            }
            a = b;
        }
        return a;
    }
}
