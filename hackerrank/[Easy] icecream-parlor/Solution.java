import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private Scanner in = new Scanner(System.in);
	private void solve(){
		int t = in.nextInt();
		while (t -- > 0){
			int m = in.nextInt();
			int n = in.nextInt();
		
			solve(n, m);	
		}
	}

	private void solve(int n, int m){
		String[] val = new String[10001];
                for (int i = 0; i < n; ++i) {
			int c = in.nextInt();
			val[c] = val[c] == null ? String.valueOf(i) : val[c] + " " + i;
		}

                for (int i = 1; i <= m/2; ++i) {
                	if (val[i] == null || val[m - i] == null) continue;
			int a, b;
                        if (i == m - i){
                        	String[] returnVal = val[i].split(" ");
				a = Integer.parseInt(returnVal[0]) + 1;
				b = Integer.parseInt(returnVal[1]) + 1;
			}
			else {
				a = Integer.parseInt(val[i].split(" ")[0]) + 1;
				b = Integer.parseInt(val[m - i].split(" ")[0]) + 1;
			}
			System.out.println(Math.min(a,b) + " " + Math.max(a,b));
			return;
                }
	}
}
