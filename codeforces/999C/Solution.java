import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();
		String s = in.next();

		if (n <= k) return;

		int[] count = new int[26];

		for (int i = 0; i < n; ++i) ++count[s.charAt(i) - 'a'];

		int total = 0; 
		for (int i = 0; total < k && i < 26; ++i){
			if (count[i] <= 0) continue;
			int diff = Math.min(count[i], k - total);
			count[i] -= diff;
			total += diff;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = n - 1; i >= 0; --i){
			if (count[s.charAt(i) - 'a']-- > 0) sb.append(s.charAt(i));
		}

		System.out.println(sb.reverse().toString());
	}
}
