import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		
		int q = in.nextInt();

		while (q-- > 0) System.out.println(makePalindrome(in.next()));
	}

	private int makePalindrome(String s){
		int i = 0;
		int j = s.length() - 1;

		char c = 0;
		while (i < j){
			if (s.charAt(i) != s.charAt(j)) {
				if (isPalindrome(s.substring(i, j))) return j;
				if (isPalindrome(s.substring(i + 1, j + 1))) return i;
				return -1;
			}
			++i;
			--j;
		}
		return -1;
	}

	private boolean isPalindrome(String s){
		for (int i = 0; i < s.length() / 2; ++i){
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
		}
		return true;
	}
}
