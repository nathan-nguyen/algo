import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] a = new int[n];
		int[] pos = new int[n+1];

		for (int i = 0; i < n; ++i) pos[in.nextInt()] = i;

		for (int i = 0; i < n; ++i) a[pos[in.nextInt()]] = i;

		for (int i = 1; i < n; ++i){
			if (a[i] < a[i-1]) {
				System.out.println(n - i);
				return;
			}
		}
		System.out.println(0);
	}
}
