import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();

		int[][] price  = new int[n][2];
		for (int i = 0; i < n; ++i) price[i][0] = in.nextInt();
		for (int i = 0; i < n; ++i) price[i][1] = in.nextInt();

		Arrays.sort(price, new Comparator<int[]>(){
			@Override public int compare(int[] o1, int[] o2){
				return Float.compare(o1[0] - o1[1],o2[0] - o2[1]);
			}
		});

		int total = 0;
		for (int i = 0; i < n; ++i){
//			System.out.println(price[i][0] + " " + price[i][1]);
			if (i < k) total += price[i][0];
			else total += Math.min(price[i][0], price[i][1]);
		}

		System.out.println(total);
	}
}
