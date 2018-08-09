import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		long total = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			int a = in.nextInt();
			int b = in.nextInt();

			if (b == 0) total += a;
			else list.add(a);
		}

		Collections.sort(list);
		
		k = Math.max(0, list.size() - k);
		for (int i = 0; i < list.size(); ++i) {
			if (i < k) total -= list.get(i);
			else total += list.get(i);
		}

		System.out.println(total);		
	}
}
