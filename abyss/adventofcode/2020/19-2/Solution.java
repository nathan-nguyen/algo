import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    interface Operator {
        List<String> check(String s);
    }

    class And implements Operator {
        List<Operator> ol = new ArrayList<>();

        public List<String> check(String s) {
            List<String> result = new ArrayList<>();
            result.add(s);

            for (Operator o: ol) {
                List<String> next = new ArrayList<>();
                for (String e: result) next.addAll(o.check(e));
                if (next.size() == 0) return next;
                result = next;
            }
            return result;
        }
    }

    class Or implements Operator {
        List<Operator> ol = new ArrayList<>();

        public List<String> check(String s) {
            List<String> result = new ArrayList<>();

            for (Operator o: ol) {
                List<String> next = o.check(s);
                result.addAll(next);
            }
            return result;
        }
    }

    class Unknown implements Operator {
        int index;
        Map<Integer, Operator> map;

        Unknown(int index, Map<Integer, Operator> map) {
            this.index = index;
            this.map = map;
        }

        public List<String> check(String s) {
//            System.out.println("Checking " + s + " with rule " + index);
            return map.get(index).check(s);
        }
    }

    class Match implements Operator {
        char c;
        Match(char c) {
            this.c = c;
        }

        public List<String> check(String s) {
            List<String> result = new ArrayList<>();
            if (s.length() > 0 && s.charAt(0) == c) result.add(s.substring(1));
            return result;
        }
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        Map<Integer, Operator> map = new HashMap<>();
        while (in.hasNext()) {
            String s = in.nextLine();
            if (s.length() == 0) break;

            if (s.equals("8: 42")) {
                s = "8: 42 | 42 8";
                System.out.println("Replaced rule 8");
            } else if (s.equals("11: 42 31")) {
                s = "11: 42 31 | 42 11 31";
                System.out.println("Replaced rule 11");
            }

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
            List<String> result = map.get(0).check(s);
            if (result.size() > 0 && result.contains("")) {
                System.out.println("Matched: " + s);
                System.out.println(result);
                ++count;
            }
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
