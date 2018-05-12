import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String a = in.next();
		int[] digit = new int[10];
		for (int i = 0; i < n; ++i){
			switch (a.charAt(i)){
				case '4': digit[2] += 2;
					++digit[3];
					break;
				case '6': ++digit[5];
					++digit[3];
					break;
				case '8': digit[2] += 3;
					++digit[7];
					break;
				case '9': ++digit[2];
					digit[3] += 2;
					++digit[7];
					break;
				default: ++digit[a.charAt(i) - '0'];
					break;
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = 9; i > 1; --i){
			for (int j = 0; j < digit[i]; ++j) result.append(i);
		}
		System.out.println(result.toString());
	}
}
