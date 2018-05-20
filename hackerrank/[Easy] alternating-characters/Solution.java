import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		while (n -- > 0){
			System.out.println(alter(in.next()));
		}
	}

	private int alter(String s){
		int count  = 0;
		for (int i = 1; i < s.length(); ++i){
			if (s.charAt(i) == s.charAt(i - 1)) ++count;	
		}

		return count;
	}
}
