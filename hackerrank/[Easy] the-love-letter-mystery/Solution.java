import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();

		while (q -- > 0) {
			System.out.println(reduce(in.next()));
		}	
	}

	private int reduce(String s){
		int count = 0;
		for (int i = 0; i < s.length() / 2; ++i){
			count += Math.abs(s.charAt(i) - s.charAt(s.length() - 1 - i));
		}
		return count;
	}
}
