import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private static final int[] a = new int[]{1, 10, 100, 1000, 10_000, 100_000, 1000_000, 10_000_000, 100_000_000};

    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) n = move(n);
        while (n % 10 != 1) n = shiftRight(n);
        System.out.println(shiftRight(n) % 100_000_000);
    }

    private int shiftRight(int n) {
        return (n % 10) * 100_000_000 + n / 10;
    }

    private int move(int n) {
        int current = (n / 100_000_000) % 10;
        int pickup = (n / 100_000) % 1000;
        int destination = (current + 7) % 9 + 1;
        int left = n % 100_000;

        int p1 = pickup % 10;
        int p2 = (pickup / 10) % 10;
        int p3 = (pickup / 100) % 10;
        while (destination == p1 || destination == p2 || destination == p3) {
            destination = (destination + 7) % 9 + 1;
        }
        System.out.println(n + " " + current + " " + pickup + " " + destination + " " + left);
        int result = current;
        int inc = 10;
        while (left > 0) {
            if (left % 10 == destination) {
                result += inc * pickup;
                inc *= 1000;
            }
            result += inc * (left % 10);
            inc *= 10;
            left /= 10;
            
        }
        System.out.println(result);
        return result;
    }
}
