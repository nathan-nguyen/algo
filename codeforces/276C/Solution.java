import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();

		int[] query = new int[n+1];
		int[] a = new int[n];

		for (int i = 0; i < n; ++i) a[i] = in.nextInt();
		Arrays.sort(a);

		while (q-- > 0){
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			query[x]++;
			query[y+1]--;
		}

		int[] freq = new int[n];
		freq[0] = query[0];
		for (int i = 1; i < n; ++i) freq[i] = freq[i-1] + query[i];

		Arrays.sort(freq);
		long result = 0;
		for (int i = 0; i < n; ++i) result += (long) a[i] * freq[i];

		System.out.println(result);
	}
}
