import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T-- > 0) {
			String s = in.next();
			System.out.println(solve(s));
		}
	}

	private long solve(String s){
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); ++i){
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < s.length(); ++j){
				sb.append(s.charAt(j));
				String k = getAnagram(sb.toString());
				if (map.containsKey(k)) map.put(k, map.get(k) + 1);
				else map.put(k, 1);
			}
		}
	
		long result = 0;
		for (String ns: map.keySet()){
			String as = getAnagram(ns);

			result += map.get(as) * (map.get(as) - 1) / 2;
		}
		return result;
	}

	private String getAnagram(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
