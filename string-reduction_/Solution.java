import java.util.Scanner;

public class Solution {

    static int stringReduction(String s) {
	int a = 0, b = 0, c = 0;
	for (int i = 0; i < s.length(); ++i){
		if (s.charAt(i) == 'a') ++a;
		else if (s.charAt(i) == 'b') ++b;
		else ++c;
	}
	if (a + b == 0 || b + c == 0 || c + a == 0) return a + b + c;
	return (a % 2 == b % 2 && b % 2 == c % 2) ? 2 : 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            int result = stringReduction(s);
            System.out.println(result);
        }
        in.close();
    }
}

