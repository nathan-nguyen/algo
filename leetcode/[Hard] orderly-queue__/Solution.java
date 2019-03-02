class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
        String min = s;
        for (int i = 1; i < s.length(); ++i) {
            s = s.substring(1) + s.charAt(0);
            if (min.compareTo(s) > 0) min = s;
        }
        return min;
    }
}

