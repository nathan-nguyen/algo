import java.util.Scanner;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; ++i) a[i] = in.nextInt();

		HashMap<Integer, Integer> map = new HashMap<>();

		int max = 1;
		int maxVal = a[0];
		for (int i = 0; i < n; ++i) {
			if (!map.containsKey(a[i] - 1)) map.put(a[i], 1);
			else {
				int v = map.get(a[i] - 1);
				map.put(a[i], v + 1);
				if (v + 1 > max) {
					max = v + 1;
					maxVal = a[i];
				}
			}
		}

		System.out.println(max);

		for (int i = 0; i < n && max > 0; ++i){
			if (a[i] == maxVal - max + 1) {
				System.out.print((i+1) + " ");
				--max;
			}
		}

		System.out.println();
	}
}
