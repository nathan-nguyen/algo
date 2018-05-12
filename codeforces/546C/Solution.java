import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int k1 = in.nextInt();
		Queue<Integer> q1 = new LinkedList<>();
		for (int i = 0; i < k1; ++i) q1.add(in.nextInt());

		int k2 = in.nextInt();
		Queue<Integer> q2 = new LinkedList<>();
		for (int i = 0; i < k2; ++i) q2.add(in.nextInt());

		int count = 0;
		HashMap<String, Boolean> map = new HashMap<>();

		while (q1.size() != 0 && q2.size() != 0){
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			for (int i : q1) sb1.append(i);
			for (int i : q2) sb2.append(i);

			if (map.get(sb1.toString()) != null && map.get(sb2.toString()) != null) break;
			map.put(sb1.toString(), true);
			map.put(sb2.toString(), true);
//			System.out.println(sb1 + " " + sb2);

			int n1 = q1.remove();
			int n2 = q2.remove();
			if (n1 > n2) {
				q1.add(n2);
				q1.add(n1);
			}
			else {
				q2.add(n1);
				q2.add(n2);
			}
			++count;
		}

		if (q1.size() == 0) System.out.println(count + " 2");
		else if (q2.size() == 0) System.out.println(count + " 1");
		else System.out.println("-1");
	}
}

