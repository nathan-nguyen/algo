class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] pr = new int[26];
        int[] sz = new int[26];

        for (int i = 0; i < 26; ++i) {
            pr[i] = i;
            sz[i] = 1;
        }

        for (String s: equations) {
            if (s.charAt(1) == '!') continue;
            union(s.charAt(0) - 'a', s.charAt(3) - 'a', pr, sz);
        }

        for (String s: equations) {
            if (s.charAt(1) == '=') continue;
            if (isConnected(s.charAt(0) - 'a', s.charAt(3) - 'a', pr)) return false;
        }
        
        return true;
    }

    private boolean isConnected(int i, int j, int[] pr) {
        while (i != pr[i]) i = pr[i];
        while (j != pr[j]) j = pr[j];
        return i == j;
    }

    private void union(int i, int j, int[] pr, int[] sz) {
        while (i != pr[i]) i = pr[i];
        while (j != pr[j]) j = pr[j];
        if (i == j) return;
        if (sz[i] > sz[j]) {
            pr[j] = i;
            sz[i] += sz[j];
        } else {
            pr[i] = j;
            sz[j] += sz[i];
        }
    }
}
