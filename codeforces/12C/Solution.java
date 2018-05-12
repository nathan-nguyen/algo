import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int[] price = new int[n];
		for (int i = 0; i < n; ++i) price[i] = in.nextInt();

		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < m; ++i) {
			String fruit = in.next();
			if (hm.get(fruit) == null) hm.put(fruit, 1);
			else hm.put(fruit, hm.get(fruit) + 1);
		}

		int[] count = new int[hm.size()];

		int index = 0;
		for (String key: hm.keySet()){
			count[index++] = hm.get(key);
		}

		Arrays.sort(price);
		Arrays.sort(count);

		long min = 0;
		long max = 0;
		for (int i = 0; i < count.length; ++i){
			min += count[i] * price[count.length - 1 - i];
			max += count[count.length - 1 - i] * price[price.length - 1 - i];
		}
		System.out.println(min + " " + max);
	}
}
