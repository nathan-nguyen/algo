import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		while (n -- > 0){
			String s = in.next();
			System.out.println(minCost(s));
		}	
	}

	private static int minCost(String s){
		int c = 0;

		int count = 0;
		for (int i = 0; i < s.length(); ++i){
			int sh = s.charAt(i) - 'a';
			if (((c >> sh) & 1) == 1) continue;
			c |= 1 << sh;
			++count;
		}
		return count;
	}
}
