import java.util.*;
import java.io.*;

public class Solution {
    private InputReader in = new InputReader(System.in);
 
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    private void solve() {
        int t = in.nextInt();
        while (t -- > 0) {
            long n = in.nextLong();
            long m = in.nextLong();
            long x1 = in.nextLong(), y1 = in.nextLong();
            long x2 = in.nextLong() + 1, y2 = in.nextLong() + 1;
            long x3 = in.nextLong(), y3 = in.nextLong();
            long x4 = in.nextLong() + 1, y4 = in.nextLong() + 1;
            solve(n, m, x1, y1, x2, y2, x3, y3, x4, y4);
        }
    }

    private void solve(long n, long m, long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        long size = n * m;
        long w = size / 2 + size % 2;
        long b = n * m - w;
       
        long sizeOne = (x2 - x1) * (y2 - y1);
        long inc = sizeOne / 2;
        if((x1 + y1) % 2 == 1) inc = sizeOne / 2 + sizeOne % 2;
        w += inc;
        b -= inc;

        long sizeTwo = (x4 - x3) * (y4 - y3);
        long dsc = sizeTwo / 2;
        if ((x3 + y3) % 2 == 0) dsc = sizeTwo / 2 + sizeTwo % 2;
        w -= dsc;
        b += dsc;

        long x5 = Math.max(x1, x3);
        long y5 = Math.max(y1, y3);
        long x6 = Math.max(x5, Math.min(x2, x4));
        long y6 = Math.max(y5, Math.min(y2, y4));

        if (x5 < x6 || y5 < y6) {
            long sizeThree = (x6 - x5) * (y6 - y5);
            long diff = sizeThree / 2;
            if ((x5 + y5) % 2 == 1) diff = sizeThree / 2 + sizeThree % 2;
            w -= diff;
            b += diff; 
        }
        System.out.println(w + " " + b);
    }
}
