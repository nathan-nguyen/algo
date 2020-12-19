import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Solution {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		int[] energy = new int[n];

		for (int i = 0; i < n; ++i) energy[i] = in.nextInt();

		long total = 0;

		for (int i = 0; i < m; ++i) {
			int p1 = in.nextInt() - 1;
			int p2 = in.nextInt() - 1;
			total += Math.min(energy[p1], energy[p2]);
		}

		System.out.println(total);
	}
}
