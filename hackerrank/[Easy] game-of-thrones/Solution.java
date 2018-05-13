import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.next();

		int[] c = new int[26];

		for (int i = 0; i < s.length(); ++i) ++c[s.charAt(i) - 'a'];

		int count = 0;
		for (int i = 0; i < 26; ++i){
			if (c[i] % 2 == 1) ++count;
		}

		System.out.println(count <= 1 ? "YES" : "NO");
	}
}
