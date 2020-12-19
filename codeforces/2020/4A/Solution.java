import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int w = in.nextInt();

		if (w <= 2 || w % 2 == 1){
			System.out.println("NO");
		}		
		else System.out.println("YES");
	}
}
