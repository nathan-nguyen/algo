import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    public static String INVALID = "$";

    interface Operator {
        String check(String s);
    }

    class And implements Operator {
        List<Operator> ol = new ArrayList<>();

        public String check(String s) {
            for (Operator o: ol) {
                s = o.check(s);
                // Not a good practice to use == with String
                if (s == INVALID) return INVALID;
            }
            return s;
        }
    }

    class Or implements Operator {
        List<Operator> ol = new ArrayList<>();

        public String check(String s) {
            for (Operator o: ol) {
                String result = o.check(s);
                // Not a good practice to use != with String
                if (result != INVALID) return result;
            }
            return INVALID;
        }
    }

    class Unknown implements Operator {
        int index;
        Map<Integer, Operator> map;

        Unknown(int index, Map<Integer, Operator> map) {
            this.index = index;
            this.map = map;
        }

        public String check(String s) {
            return map.get(index).check(s);
        }
    }

    class Match implements Operator {
        char c;
        Match(char c) {
            this.c = c;
        }

        public String check(String s) {
            if (s.charAt(0) == c) return s.substring(1);
            return INVALID;
        }
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        Map<Integer, Operator> map = new HashMap<>();
        while (in.hasNext()) {
            String s = in.nextLine();
            if (s.length() == 0) break;

            String[] sp = s.split(": ");
            int rule = Integer.parseInt(sp[0]);
            Operator operator;
            if (sp[1].contains("\"")) operator = new Match(sp[1].charAt(1));
            else if (sp[1].contains(" | ")) {
                String[] orRule = sp[1].split(" \\| ");
                operator = new Or();
                for (String ar: orRule) ((Or) operator).ol.add(parseAnd(ar, map));
            }
            else operator = parseAnd(sp[1], map);
            map.put(rule, operator);
        }

        int count = 0;
        while (in.hasNext()) {
            String s = in.next();
            if (map.get(0).check(s).length() == 0) ++count;
        }
        System.out.println(count);
    }

    private Operator parseAnd(String s, Map<Integer, Operator> map) {
        String[] sp = s.split(" ");
        if (sp.length == 1) return new Unknown(Integer.parseInt(sp[0]), map);
        And and = new And();
        for (String x: sp) and.ol.add(new Unknown(Integer.parseInt(x), map));
        return and;
    }
}
