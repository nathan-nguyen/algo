import java.util.*;

public class Solution {
    private Scanner in = new Scanner(System.in);
    private String[] token;

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() throws Exception {
        String s = in.next();
        this.token = s.split(",");

        IntCodeComputer intCodeComputer = new IntCodeComputer();
        intCodeComputer.addInput("2");
        while (true) System.out.println("Output: " + intCodeComputer.run());
        
    }

    class IntCodeComputer {
        public static final String ZERO = "0";
        private static final int MAX_INST_COUNTER = 10000;
        private int p = 0;
        private int relativeBase = 0;
        private Map<String, String> a = new HashMap<>();
        private Queue<String> inputQueue = new LinkedList<>();

        IntCodeComputer() {
            for (int i = 0; i < token.length; ++i) a.put(String.valueOf(i), token[i]);
        }

        private void addInput(String input) {
            this.inputQueue.offer(input);
        }

        private String accessAddress(int address) {
            return a.getOrDefault(String.valueOf(address), ZERO);
        }

        private String accessAddress(String address) {
            return a.getOrDefault(address, ZERO);
        }

        private String run() throws Exception {
            while (p < MAX_INST_COUNTER) {
                int number = Integer.parseInt(accessAddress(p));
                int code = number % 100;
                int[] mode = new int[3];
                mode[0] = (number / 100) % 10;
                mode[1] = (number / 1000) % 10;
                mode[2] = (number / 10000) % 10;

                switch (code) {
                    case 99: throw new Exception("Exit code 99");
                    case 1: plusInstruction(mode);  break;
                    case 2: multiplyInstruction(mode);  break;
                    case 3: inputInstruction(mode); break;
                    case 4: return outputInstruction(mode);
                    case 5: jumpIfTrueInstruction(mode);    break;
                    case 6: jumpIfFalseInstruction(mode);   break;
                    case 7: lessThanInstruction(mode);  break;
                    case 8: equalsInstruction(mode);    break;
                    case 9: adjustRelativeBaseInstruction(mode);    break;
                    default: throw new Exception("Invalid instruction code: " + number);
                }
            }
            throw new Exception("Invalid code flow");
        }

        private String getNumber(int mode, String value) throws Exception {
            if (mode == 0) return accessAddress(value);
            if (mode == 1) return value;
            if (mode == 2) return accessAddress(relativeBase + Integer.parseInt(value));
            throw new Exception("Invalid getNumber mode " + mode + " " + value);
        }

        private String getPosition(int mode, String value) throws Exception {
            if (mode == 0) return value;
            if (mode == 2) return String.valueOf(relativeBase + Integer.parseInt(value));
            throw new Exception("Invalid getPosition mode " + mode + " " + value);
        }

        private void plusInstruction(int[] mode) throws Exception {
            System.out.println("[Plus Instruction] " + p + " " + accessAddress(p) + " " + accessAddress(p + 1) + " " + accessAddress(p + 2) + " " + accessAddress(p + 3));
            long result = Long.parseLong(getNumber(mode[0], accessAddress(p + 1))) + Long.parseLong(getNumber(mode[1], accessAddress(p + 2)));
            a.put(getPosition(mode[2], accessAddress(p + 3)), String.valueOf(result));
            p += 4;
        }

        private void multiplyInstruction(int[] mode) throws Exception {
            System.out.println("[Multiply Instruction] " + p + " " + accessAddress(p) + " " + accessAddress(p + 1) + " " + accessAddress(p + 2) + " " + accessAddress(p + 3));
            long result = Long.parseLong(getNumber(mode[0], accessAddress(p + 1))) * Long.parseLong(getNumber(mode[1], accessAddress(p + 2)));
            a.put(getPosition(mode[2], accessAddress(p + 3)), String.valueOf(result));
            p += 4;       
        }

        private void inputInstruction(int[] mode) throws Exception {
            System.out.println("[Input Instruction] " + p + " " + accessAddress(p) + " " + accessAddress(p + 1));
            a.put(getPosition(mode[0], accessAddress(p + 1)), inputQueue.poll());
            p += 2;
        }

        private String outputInstruction(int[] mode) throws Exception {
            System.out.println("[Output Instruction] " + p + " " + accessAddress(p) + " " + accessAddress(p + 1));
            String result = getNumber(mode[0], accessAddress(p + 1));
            p += 2;
            return result;
        }

        private void jumpIfTrueInstruction(int[] mode) throws Exception {
            System.out.println("[Jump If True Instruction] " + p + " " + accessAddress(p) + " " + accessAddress(p + 1) + " " + accessAddress(p + 2));
            if (!getNumber(mode[0], accessAddress(p + 1)).equals(ZERO)) {
                p = Integer.parseInt(getNumber(mode[1], accessAddress(p + 2)));
            }
            else p += 3;
        }

        private void jumpIfFalseInstruction(int[] mode) throws Exception {
            if (getNumber(mode[0], accessAddress(p + 1)).equals(ZERO)) {
                p = Integer.parseInt(getNumber(mode[1], accessAddress(p + 2)));
            }
            else p += 3;
        }

        private void lessThanInstruction(int[] mode) throws Exception {
            System.out.println("[Less Than Instruction] " + p + " " + accessAddress(p) + " " + accessAddress(p + 1) + " " + accessAddress(p + 2) + " " + accessAddress(p + 3));
            long first = Long.parseLong(getNumber(mode[0], accessAddress(p + 1)));
            long second = Long.parseLong(getNumber(mode[1], accessAddress(p + 2)));
            a.put(getPosition(mode[2], accessAddress(p + 3)), first < second ? "1" : "0");
            p += 4;
        }

        private void equalsInstruction(int[] mode) throws Exception {
            String first = getNumber(mode[0], accessAddress(p + 1));
            String second = getNumber(mode[1], accessAddress(p + 2));
            a.put(getPosition(mode[2], accessAddress(p + 3)), first.equals(second) ? "1" : "0");
            p += 4;
        }

        private void adjustRelativeBaseInstruction(int[] mode) throws Exception {
            System.out.println("[Adjust Relative Base Instruction] " + p + " " + accessAddress(p) + " " + accessAddress(p + 1));
            int adjustValue = Integer.parseInt(getNumber(mode[0], accessAddress(p + 1)));
            relativeBase += adjustValue;
            p += 2;
        }
    }
}
