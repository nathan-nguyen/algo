class Solution {
    public int newInteger(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 9);
            n /= 9;
        }
        return Integer.parseInt(sb.reverse().toString());
    }
}
