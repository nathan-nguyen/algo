import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    class Square {
        int id;
        int[] side;
        Square(int id, int[] side) {
            this.id = id;
            this.side = side;
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
                squareList.add(new Square(id, a));
                squareList.add(new Square(id, rotateSquare(a, 1)));
                squareList.add(new Square(id, rotateSquare(a, 2)));
                squareList.add(new Square(id, rotateSquare(a, 3)));
                int[] b = flipSquare(a);
                squareList.add(new Square(id, b));
                squareList.add(new Square(id, rotateSquare(b, 1)));
                squareList.add(new Square(id, rotateSquare(b, 2)));
                squareList.add(new Square(id, rotateSquare(b, 3)));
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

        System.out.println(backtrack(squareList, map));
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

    private int[] flipSquare(int[] a) {
        int[] b = new int[4];
        b[0] = flip(a[0]);
        b[1] = a[3];
        b[2] = flip(a[2]);
        b[3] = a[1];
        return b;
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

    private long backtrack(List<Square> squareList, Map<Integer, List<Square>>[] map) {
        int total = squareList.size() / 8;
        int n = (int) Math.sqrt(total);
        Stack<Square> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for (Square square: squareList) {
            stack.push(square);
            visited.add(square.id);
            if (backtrack(stack, map, visited, n)) {
                for (Square e: stack) System.out.println(e.id);
                return (long) stack.get(0).id * stack.get(n-1).id * stack.get(total - n).id * stack.get(total - 1).id;
            }
            visited.remove(square.id);
            stack.pop();
        }
        return -1;
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
}
