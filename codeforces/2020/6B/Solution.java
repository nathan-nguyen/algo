import java.util.Scanner;
import java.util.HashSet;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();	
		int m = in.nextInt();

		char p = in.next().charAt(0);

		String[] map = new String[n];
		for (int i = 0; i < n; ++i) map[i] = in.next();

		HashSet<Character> set = new HashSet<>();

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				char c = map[i].charAt(j);
				if (map[i].charAt(j) == p || map[i].charAt(j) == '.') continue;

				if (i > 0 && map[i-1].charAt(j) == p) set.add(c);
				else if (i + 1 < n && map[i + 1].charAt(j) == p) set.add(c);
				else if (j > 0 && map[i].charAt(j - 1) == p) set.add(c);
				else if (j + 1 < m && map[i].charAt(j + 1) == p) set.add(c);
			}
		}

		System.out.println(set.size());
	}
}
