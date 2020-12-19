import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.solve());
	}

	private int solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		if (n <= 0) return -1;

		int a = (int) Math.sqrt(n);

		if (a * a == n) return 0;

		for (int i = a; i > 0; --i){
			int result = valid(n, i * i);
			if (result > 0) return result;
		}
		return -1;
		
	}

	private int valid(int n, int k){
		int result = String.valueOf(n).length() - String.valueOf(k).length();
		while (n > 0 && k > 0){
			if (n % 10 == k % 10) k /= 10;
			n /= 10;
		}

		if (k == 0) return result;
		return -1;
	}
}
