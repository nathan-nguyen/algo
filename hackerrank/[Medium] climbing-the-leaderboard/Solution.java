import java.util.Scanner;
import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < n; ++i) set.add(in.nextInt());

		int m = in.nextInt();
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);

		while (m -- > 0){
			int index = Collections.binarySearch(list, in.nextInt());
			System.out.println(index >= 0 ? (set.size() - index) : (set.size() + index + 2));
		}
	}
}
