import java.util.Scanner;
import java.util.HashMap;

public class Solution {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<String, Integer> hm = new HashMap<>();

		while (n-- > 0){
			String str = in.next();
			Integer result = hm.get(str);
			if (result == null) {
				hm.put(str, 0);
				System.out.println("OK");
			}
			else {
				hm.put(str, ++result);
				System.out.println(str + result);
			}
		}
	}
}
