import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.solve());
	}

	private int solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for (int i = 1; i <= 512; ++i){
			if (Integer.parseInt(Integer.toBinaryString(i)) > n) return i - 1;
		}

		return 512;
	}
}
