import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		String s = in.next();
		char[] cList = s.toCharArray();

		int streak = 0, result = 0;
		for (int i = 0; i < s.length(); ++i){
			if (cList[i] != '.'){
				result += Math.max(streak - 1, 0);
				streak = 0;
			}
			else ++streak;
		}

		result += Math.max(streak - 1, 0);

		while (m-- > 0){
			int pos = in.nextInt() - 1;
			char c = in.next().charAt(0);

			if (c == cList[pos] || (c != '.' && cList[pos] != '.')){
				System.out.println(result);
				continue;
			}

			int left = 0, right = 0;

			for (int i = pos - 1; i >= 0 && i >= pos -2; --i){
				if (cList[i] != '.') break;
				++left;
			}

			for (int i = pos + 1; i < s.length() && i <= pos + 2; ++i){
				if (cList[i] != '.') break;
				++right;
			}

			int min = Math.min(left, right);
			int max = left + right - min;
			int amount = (max >= 1) ? Math.min(2, min + 1) : 0;

			if (c == '.') result += amount;
			else result -= amount;

			cList[pos] = c;
			System.out.println(result);
		}
	}
}
