import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.solve());
	}

	private int solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		// Using binary search to find the solution, f(left) always <= n, f(right) always > n

		int left = 1, right = 513;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (Integer.parseInt(Integer.toBinaryString(mid)) > n) right = mid;
			else left = mid;
		}
		return left;
	}
}
