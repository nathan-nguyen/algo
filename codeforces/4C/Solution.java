import java.util.Scanner;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		HashMap<String, Integer> map = new HashMap<>();

		int n = in.nextInt();

		while (n -- > 0){
			String s = in.next();
			if (!map.containsKey(s)) {
				map.put(s, 1);
				System.out.println("OK");
			}
			else {
				int v = map.get(s);
				System.out.println(s + v);
				map.put(s, v + 1);
			}
		}
	}
}
