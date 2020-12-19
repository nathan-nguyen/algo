import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String s = in.next();

		boolean[] lt = new boolean[26];
		char[] result = new char[k];
		
		char minChar = 'z';
		for (int i = 0; i < n; ++i) {
			lt[s.charAt(i) - 'a'] = true;
			if (minChar > s.charAt(i)) minChar = s.charAt(i);
		}

		for (int i = 0; i < Math.min(n,k) ; ++i) result[i] = s.charAt(i);

		if (k > n) {
			for (int i = n; i < k; ++i) result[i] = minChar;
			System.out.println(result);
			return;
		}

		for (int i = k - 1; i >= 0; --i){
			if (s.charAt(i) == 'z'){
				result[i] = minChar;
				continue;
			}
			for (int j = s.charAt(i) - 'a' + 1; j < 26; ++j) {
				if (lt[j]) {
					result[i] = (char) (j + 'a');
					System.out.println(result);
					return;
				}
				else result[i] = minChar;
			}
		}
	}
}
