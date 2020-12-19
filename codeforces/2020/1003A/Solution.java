import java.util.Scanner;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;
		while (n -- > 0) {
			int coin = in.nextInt();
			int freq = map.getOrDefault(coin, 0) + 1;
			max = Math.max(max, freq);
			map.put(coin, freq);
		}
		System.out.println(max);
	}
}
