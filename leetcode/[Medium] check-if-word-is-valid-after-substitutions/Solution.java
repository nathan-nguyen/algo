class Solution {
    public boolean isValid(String s) {
        if (s.length() < 3) return false;
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a') ++a;
            else if (s.charAt(i) == 'b') ++b;
            else if (s.charAt(i) == 'c') ++c;
            else return false;
            if (a < b || b < c) return false;
        }
        return a == b && b == c;
    }
}

