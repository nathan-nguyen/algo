import java.util.Scanner;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();

		int n = in.nextInt();
		int m = in.nextInt();

		while (n -- > 0) {
			String s = in.next();
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		while (m -- > 0) {
			String s = in.next();
			int k = map.getOrDefault(s, 0);
			if (k == 0) {
				System.out.println("No");
				return;
			}
			map.put(s, k - 1);
		}

		System.out.println("Yes");
	}
}
