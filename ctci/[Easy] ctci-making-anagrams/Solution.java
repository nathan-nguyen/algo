import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();

		int[] count = new int[26];
		for (int i = 0; i < a.length(); ++i) ++count[a.charAt(i) - 'a'];
		for (int i = 0; i < b.length(); ++i) --count[b.charAt(i) - 'a'];

		int result = 0;
		for (int i = 0; i < 26; ++i) result += Math.abs(count[i]);

		System.out.println(result);

		in.close();
	}
}
