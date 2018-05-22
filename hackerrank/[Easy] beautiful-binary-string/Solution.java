import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		String s = in.next();

		int count = 0;
		String t = "010";

		for (int i = 0, j = 0; i < s.length(); ++i){
			if (s.charAt(i) == t.charAt(j)) ++j;
			else {
				if (j == 1) --i;
				j = 0;
			}

			if (j == 3) {
				++count;
				j = 0;
			}
		}
		System.out.println(count);
	}
}
