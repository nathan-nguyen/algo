import java.util.Scanner;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;
		hm.put(0, count++);

		int n = in.nextInt();
		int time = 1;
		while (n-- > 0){
			int t = in.nextInt();
			if (hm.get(t) != null) {
				hm.put(time, hm.get(t));
				hm.remove(t);
			}
			else hm.put(time, count++);

			++time;
		}
		System.out.println(count);
	}
}
