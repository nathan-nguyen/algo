import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t -- > 0){
            String s = in.next();
		    int n = in.nextInt();
		    solve(s, n);
        }
	}
	
	private void solve(String s, int n){
	    if (n == 1) {
		System.out.println(s);
		return;
	    }

	    StringBuilder[] sb = new StringBuilder[n];
		for (int i = 0; i < n; ++i) sb[i] = new StringBuilder();

		int t = 2 * (n - 1);

		for (int  i = 0 ; i < s.length(); ++i){
			if (i % t <= n - 1) sb[i % t].append(s.charAt(i));
			else sb[2 * n - 2 - i % t].append(s.charAt(i));
		}
		
		for (int i = 0; i < n ; ++i) System.out.print(sb[i]);
		System.out.println();
	}
}

