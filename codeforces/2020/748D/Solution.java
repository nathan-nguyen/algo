import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private HashMap<String, Integer> index = new HashMap<>();
        private ArrayList<ArrayList<Integer>> vList = new ArrayList<>();
	private int total = 0;

	private int minNegPalDoub = 0;
	private int maxPosPalSing = 0;

	private void solve(){
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int n = in.nextInt();
		boolean[] isPalidrome = new boolean[k];

		HashSet<String> sList = new HashSet<>(); 

		int count = 0;
		for (int i = 0; i < k; ++i){
			String s = in.next();
			int val = in.nextInt();

			if (index.get(s) == null) {
				ArrayList<Integer> al = new ArrayList<>();
				vList.add(al);
				index.put(s, count++);
			}
			vList.get(index.get(s)).add(val);

			String rs = reverse(s);
			if (!sList.contains(s) && !sList.contains(rs)) sList.add(s);
		}

		for (String s: sList){
			String rs = reverse(s);
			if (index.get(s) == null || index.get(rs) == null) continue;
			if (s.equals(rs)) {
				processPalidrome(s);
				continue;
			}

			ArrayList<Integer> sL = vList.get(index.get(s));
			ArrayList<Integer> rsL = vList.get(index.get(rs));

			Collections.sort(sL, Collections.reverseOrder());
			Collections.sort(rsL, Collections.reverseOrder());
			
			for (int i = 0; i < Math.min(sL.size(), rsL.size()); ++i){
				int local = sL.get(i) + rsL.get(i);
				if (local > 0) total += local;
				else break;
			}
			
		}
		if (maxPosPalSing == 0 || maxPosPalSing < -minNegPalDoub) total -= minNegPalDoub;
		else total += maxPosPalSing;
		System.out.println(total);
	}

	private void processPalidrome(String s){
		ArrayList<Integer> al = vList.get(index.get(s));
		Collections.sort(al, Collections.reverseOrder());

		for (int i = 0; i < al.size(); i+=2){
			int first = al.get(i);

			if (first <= 0) return;

			if (i+1 == al.size()) {
				maxPosPalSing = Math.max(maxPosPalSing, first);
				return;
			}

			int second = al.get(i+1);
			if (first + second <= 0) {
				maxPosPalSing = Math.max(maxPosPalSing, first);
				return;
			}
			total += (first + second);
			if (second < 0) {
				minNegPalDoub = Math.min(minNegPalDoub, second);
				return;
			}
		}
	}

	private String reverse(String s){
		StringBuilder sb = new StringBuilder(s);
		sb = sb.reverse();
		return sb.toString();
	}
}

