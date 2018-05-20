import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int result = -1;

		while (n -- > 0){
			result &= countGem(in.next());
		}

		int count = 0;
		for (int i = 0; i < 26; ++i){
			if (((result >> i) & 1 )== 1) ++count;
		}

		System.out.println(count);
	}

	private int countGem(String s){
		int result = 0;

		for (int i = 0; i < s.length(); ++i){
			result |= (1 << (s.charAt(i) - 'a'));
		}
		return result;
	}
}

