class Solution {
    public List<String> commonChars(String[] a) {
        int[] result = process(a[0]);
        for (int i = 1; i < a.length; ++i) {
            result = combine(result, process(a[i]));
        }
        List<String> l = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            for (int k = 0; k < result[i]; ++k) l.add((char) (i + 'a') + "");
        }
        return l;
    }

    private int[] combine(int[] a, int[] b) {
        int[] c = new int[26];
        for (int i = 0; i < 26; ++i) c[i] = Math.min(a[i], b[i]);
        return c;
    }

    private int[] process(String s) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); ++i) ++c[s.charAt(i) - 'a'];
        return c;
    }
}

