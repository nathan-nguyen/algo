import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private int[] step = new int[37];

	private void solve(){
		Scanner in = new Scanner(System.in);

		step[0] = 1;
		for (int i = 1; i <= 36; ++i) step[i] = -1;

		climb(36);

		int s = in.nextInt();
		while (s -- > 0) System.out.println(climb(in.nextInt()));
	}

	private int climb(int s){
		if (s < 0) return 0;

		if (step[s] != -1) return step[s];

		step[s] = climb(s - 3) + climb(s - 2) + climb(s - 1);
		return step[s];
	}
}
