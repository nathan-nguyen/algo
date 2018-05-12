import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String n = in.next();

		int result = solve(n);
		if (result >=0) System.out.println("YES\n" + result);
		else System.out.println("NO");
	}

	public static int solve(String n){
		int l = n.length();
		int[] first = new int[8];
		int[] second = new int[8];

		for (int i = 0; i < 8; ++i) {
			first[i] = -1;
			second[i] = -1;
		}

		int firstChar = n.charAt(l-1) - '0';
		if (firstChar % 8 == 0) return firstChar;

		first[firstChar % 8] = firstChar;

		if (l >= 2){
			int secondChar = n.charAt(l-2) - '0';
			if (secondChar % 8 == 0) return secondChar;
			int lastTwo = secondChar * 10 + firstChar;
			if (lastTwo % 8 == 0) return lastTwo;
			first[secondChar % 8] = secondChar;
			second[lastTwo % 8] = lastTwo;
		}

		for (int i = l-3; i >= 0; --i){
			int nextDigit = n.charAt(i) - '0';
			if (nextDigit % 8 == 0) return nextDigit;
			for (int j = 0; j < 8 ; ++j){
				if (second[j] > 0) {
					int lastThree = nextDigit * 100 + second[j];
					if (lastThree % 8 == 0) return lastThree;
				}
			}
			for (int j = 0; j < 8; ++j){
				if (first[j] > 0){
					int lastTwo = nextDigit * 10 + first[j];
					if (lastTwo % 8 == 0) return lastTwo;
					second[lastTwo % 8] = lastTwo;
				}
			}
			first[nextDigit % 8] = nextDigit;
		}

		return -1;
	}
}
