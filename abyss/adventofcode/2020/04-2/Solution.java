import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        List<String> ppl = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.length() > 0) sb.append(" " + s);
            else if (sb.length() > 0) {
                ppl.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) ppl.add(sb.toString());

        int count = 0;
        for (String s: ppl) {
            if (isValid(s)) ++count;
        }
        System.out.println(count);
    }

    private static String[] REQUIRED_FIELDS = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
    private static String[] EYE_COLORS = new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};

    private boolean isValid(String s) {
        for (String rf: REQUIRED_FIELDS) {
            if (!s.contains(rf + ":")) return false;
        }

        String[] sp = s.split(" ");
        Map<String, String> map = new HashMap<>();
        for (String spe: sp) {
            if (spe.length() == 0) continue;
            String[] kv = spe.split(":");
            map.put(kv[0], kv[1]);
        }

        String byr = map.get("byr");
        if (!checkLength(byr, 4) || !checkRange(Integer.parseInt(byr), 1920, 2002)) return false;

        String iyr = map.get("iyr");
        if (!checkLength(iyr, 4) || !checkRange(Integer.parseInt(iyr), 2010, 2020)) return false;

        String eyr = map.get("eyr");
        if (!checkLength(eyr, 4) || !checkRange(Integer.parseInt(eyr), 2020, 2030)) return false;

        String hgt = map.get("hgt");
        if (checkSuffix(hgt, "in")) {
            int hgtNumber = Integer.parseInt(hgt.substring(0, hgt.length() -2));
            if (!checkRange(hgtNumber, 59, 76)) return false;
        } else if (checkSuffix(hgt, "cm")) {
            int hgtNumber = Integer.parseInt(hgt.substring(0, hgt.length() -2));
            if (!checkRange(hgtNumber, 150, 193)) return false;
        } else return false;

        String hcl = map.get("hcl");
        if (checkSurfix(hcl, "#")) {
            String colorCode = hcl.substring(1);
            if (!checkLength(colorCode, 6)) return false;
            if (!checkColorCode(colorCode)) return false;
        } else return false;

        String ecl = map.get("ecl");
        if (!checkEyeColor(ecl)) return false;
        
        String pid = map.get("pid");
        if (!checkLength(pid, 9) || !checkDigitFormat(pid)) return false;

        return true;
    }

    private boolean checkLength(String s, int n) {
        return s.length() == n;
    }

    private boolean checkRange(int n, int s, int e) {
        return n >= s && n <= e;
    }

    private boolean checkSuffix(String s, String suffix) {
        if (s.length() < suffix.length()) return false;
        return s.substring(s.length() - suffix.length()).equals(suffix);
    }

    private boolean checkSurfix(String s, String surfix) {
        if (s.length() < surfix.length()) return false;
        return s.substring(0, surfix.length()).equals(surfix);
    }

    private boolean checkColorCode(String s) {
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!((c >= '0' && c <= '9') || (c >= 'a' &&  c <= 'z'))) return false;
        }
        return true;
    }

    private boolean checkEyeColor(String s) {
        for (String c: EYE_COLORS) {
            if (s.equals(c)) return true;
        }
        return false;
    }

    private boolean checkDigitFormat(String s) {
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }
}
