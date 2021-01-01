class Solution {
    public String getPermutation(int n, int k) {
        --k;
        String s = new String();
        for (int i = 1; i <= n; ++i) s += i;

        int[] f = new int[10];
        f[0] = 1;
        
        for (int i = 1; i < 10; ++i) f[i] = f[i-1] * i;
        StringBuilder result = new StringBuilder();

        for (int i = n-1; i >= 0; --i){
            int t = k / f[i];
            result.append(s.charAt(t));
            s = s.substring(0, t) + s.substring(t + 1);
            k %= f[i];
        }
        return result.toString();
    }
}
