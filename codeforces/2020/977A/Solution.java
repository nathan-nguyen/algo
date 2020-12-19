import java.util.Scanner;

public class Solution {
	public static void main(String args[]){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();

		while (k -- > 0){
			if (n % 10 == 0) n /= 10;
			else --n;
		}

		System.out.println(n);
	}
}
