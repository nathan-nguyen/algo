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

		int count = s.charAt(0) == 'x' ? 1 : 0;
		int result = 0;
		for (int i = 1; i < n; ++i){
			if (s.charAt(i) != 'x') {
				result += Math.max(0, count - 2);
				count = 0;
			}
			else ++count;
		}
		result += Math.max(0, count - 2);
		System.out.println(result);
	}
}
