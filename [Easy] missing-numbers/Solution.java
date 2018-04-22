import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] count = new int[10001];

		while (n-- > 0) ++count[in.nextInt()];

		int m = in.nextInt();
		while (m-- > 0) --count[in.nextInt()];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10001; ++i) {
			if (count[i] < 0) sb.append(i + " ");
		}
		System.out.println(sb);
	}
}
