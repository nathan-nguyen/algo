import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[][] data = new int[n][2];
		for (int i = 0; i < n; ++i){
			data[i][0] = in.nextInt();
			data[i][1] = in.nextInt();
		}

		Arrays.sort(data, new Comparator<int[]>(){
			@Override public int compare(int[] o1, int[] o2){
				if (o1[0] == o2[0]) return Double.compare(o1[1], o2[1]);
				return Double.compare(o1[0],o2[0]);
			}
		});

		int date = data[0][1];
		for (int i = 1; i < n; ++i){
			if (data[i][1] >= date) date = data[i][1];
			else date = data[i][0];
		}
		System.out.println(date);
	}
}
