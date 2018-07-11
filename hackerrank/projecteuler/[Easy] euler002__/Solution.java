import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		ArrayList<Long> list = new ArrayList<>();
		ArrayList<Long> total = new ArrayList<>();
		list.add(0L);	list.add(2L);
		total.add(0L);	total.add(2L);

		long result = 4 * list.get(list.size() - 1) + list.get(list.size() - 2);
		long nextTotal = result + total.get(total.size() - 1);
		while (result <= 4_0000_0000_0000_0000L) {
			list.add(result);
			total.add(nextTotal);
			result = 4 * list.get(list.size() - 1) + list.get(list.size() - 2);
			nextTotal = result + total.get(total.size() - 1);
		}

		while (T -- > 0){
			long n = in.nextLong();
			int index = Collections.binarySearch(list, n);
			index = index >= 0 ? index : -index - 1;
			System.out.println(index == 0 ? 0 : total.get(index-1));
		}
	}
}
