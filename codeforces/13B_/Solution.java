import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    class Segment {
        int x1, y1, x2, y2;
        Segment(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x1;
            this.y2 = y2;
        }
    }

    private int[] getCommonEndPoint(Segment s1, Segment s2) {
            if ((s1.x1 == s2.x1 && s1.y1 == s2.y1) || (s1.x1 == s2.x2 && s1.y1 == s2.y2)) return new int[]{s1.x1, s1.y1};
            if ((s1.x2 == s2.x1 && s1.y2 == s2.y1) || (s1.x2 == s2.x2 && s1.y2 == s2.y2)) return new int[]{s1.x2, s1.y2};
            return null;
        }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while (n -- > 0) System.out.println(solve(in) ? "YES" : "NO");
    }
   
    private boolean solve(Scanner in) { 
        Segment s1 = new Segment(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        Segment s2 = new Segment(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
        Segment s3 = new Segment(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());

        int[] result;
        result = getCommonEndPoint(s1, s2);
        if (result == null) {
            Segment s = s3;
            s3 = s1;
            s1 = s;
            result = getCommonEndPoint(s1, s2);
        }
        if (result == null) {
            Segment s = s3;
            s3 = s2;
            s2 = s;
            result = getCommonEndPoint(s1, s2);
        }
        if (result == null) return false;


        // Check angle between two vector
        if (!checkAngle(s1, s2, result)) return false;

        // Check Ratio
        if (!checkRation(s1, s2, s3)) return false;
        return true;
    }

    private boolean checkAngle(Segment s1, Segment s2, int[] point) {
        // Implementation
        return true;
    }

    private boolean checkRation(Segment s1, Segment s2, Segment s3) {
        // Implementation
        return true;
    }
}
