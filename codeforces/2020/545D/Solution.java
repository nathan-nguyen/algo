import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int[] t = new int[n];
		int total = 0;
		int count = 0;

		for (int i = 0; i < n; ++i) t[i] = in.nextInt();

		Arrays.sort(t);
//		for (int i = 0; i < n; ++i) System.out.println(t[i]);

		for (int i = 0; i < n; ++i){
			if (total <= t[i]) {
				total += t[i];
				++count;
			}
		}

		System.out.println(count);	
	}
}
