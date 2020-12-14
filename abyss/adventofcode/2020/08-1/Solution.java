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
        System.out.println(execute(input));
    }

    private int execute(List<String> input) {
        int acc = 0;
        int next = 0;
        boolean[] executed = new boolean[input.size()];
        while (!executed[next]) {
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
        return acc;
    }
}
