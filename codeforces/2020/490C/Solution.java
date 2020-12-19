import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int a = in.nextInt();
		int b = in.nextInt();

		long[] left  = new long[s.length()];
		long[] right = new long[s.length()];

		if (s.charAt(0) == '0') {
			System.out.println("NO");
			return;
		}

		left[0] = (s.charAt(0) - '0') % a;
		for (int i = 1; i < s.length(); ++i){
			left[i] = (left[i-1] * 10 + (s.charAt(i) - '0')) % a;
		}

		right[s.length() - 1] = (s.charAt(s.length() - 1) - '0') % b;
		int mul = 1;
		for (int i = s.length() - 2; i >=0 ; --i){
			mul = (mul * 10) % b;
			right[i] = (mul * (s.charAt(i) - '0') + right[i+1]) % b;
		}

		StringBuilder leftResult = new StringBuilder();
		StringBuilder rightResult = new StringBuilder();

		for (int i = 0; i < s.length() - 1; ++i){
			leftResult.append(s.charAt(i));
			if (left[i] == 0 && right[i+1] == 0 && s.charAt(i+1) != '0'){
				for (int j = i + 1; j < s.length(); ++j){
					if (rightResult.length() == 0 && s.charAt(j) == '0') continue;
					rightResult.append(s.charAt(j));
				}
				break;
			}
		}


		if (leftResult.length() == 0 || rightResult.length() == 0) System.out.println("NO");
		else {
			System.out.println("YES");
			System.out.println(leftResult.toString());
			System.out.println(rightResult.toString());
		}
	}
}
