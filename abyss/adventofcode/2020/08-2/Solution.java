import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            input.add(s); 
        }
        System.out.println(input);
        for (int i = 0; i < input.size(); ++i) {
            String origin = input.get(i);
            
            if (origin.contains("nop")) input.set(i, origin.replaceAll("nop", "jmp"));
            else if (origin.contains("jmp")) input.set(i, origin.replaceAll("jmp", "nop"));
            else continue;

            int acc = execute(input);
            System.out.println(input + " " + acc);
            input.set(i, origin);
            if (acc != Integer.MIN_VALUE) {
                System.out.println(acc);
                return;
            }
        }
    }

    private int execute(List<String> input) {
        int acc = 0;
        int next = 0;
        boolean[] executed = new boolean[input.size()];
        while (next < input.size() && !executed[next]) {
            executed[next] = true;
            String executeCode = input.get(next).substring(0, 3);
            int number = Integer.parseInt(input.get(next).substring(4));
            if (executeCode.equals("nop")) ++next;
            else if (executeCode.equals("jmp")) next += number; 
            else if (executeCode.equals("acc")) {
                ++next;
                acc += number;
            }
        }
        if (next == input.size()) return acc;
        return Integer.MIN_VALUE;
    }
}
