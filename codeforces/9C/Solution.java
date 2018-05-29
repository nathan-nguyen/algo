import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();


		for (int i = 1; i <= 512; ++i){
			if (Integer.parseInt(Integer.toBinaryString(i)) > n){
				System.out.println(i - 1);
				return;
			}
		}

		System.out.println(512);
	}
}
