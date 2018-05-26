import java.util.Scanner;
import java.util.HashMap;

public class Solution{
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		String s = in.next();

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 1; i < n; ++i){
			String k = "" + s.charAt(i-1) + s.charAt(i);
			if (map.containsKey(k)) map.put(k, map.get(k) + 1);
			else map.put(k, 1);
		}

		int maxFreq = Integer.MIN_VALUE;
		String result = "";
		for (String k : map.keySet()){
			if (map.get(k) > maxFreq) {
				maxFreq = map.get(k);
				result = k;
			}
		}
		System.out.println(result);
	}
}
