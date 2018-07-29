import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] freqMap = new int[1000001];
        while (q -- > 0) {
            int command = in.nextInt();
            int value = in.nextInt();
            if (command == 1) {
                int freq = map.getOrDefault(value, 0);

                --freqMap[freq];
                ++freqMap[++freq];
                map.put(value, freq);
            }
            else if (command == 2 && map.containsKey(value)) {
                int freq = map.get(value);

                --freqMap[freq];
                freq = Math.max(0, --freq);

                ++freqMap[freq];
                map.put(value, freq);
            }
            else if (command == 3) {
                System.out.println(value > 1000_000 || freqMap[value] == 0 ? 0 : 1);
            }
        }
    }
}

