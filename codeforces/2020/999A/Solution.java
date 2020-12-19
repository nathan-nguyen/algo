import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int[] a = new int[n];
		int count = 0;

		for (int i = 0; i < n; ++i) a[i] = in.nextInt();

		for (int i = 0; i < n; ++i){
			if (a[i] > k) break;
			++count;
		}

		if (count < n) {
			for (int i = n - 1; i >= 0; --i){
				if (a[i] > k) break;
				++count;
			}
		}

		System.out.println(count);
	}
}
