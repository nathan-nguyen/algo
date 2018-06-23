import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int l = in.nextInt();
		int r = in.nextInt();
		int k = in.nextInt();

		l = l % k == 0 ? l / k - 1: l / k;
		r /= k;

		System.out.println(l > r ? 0 : r - l);
	}
}
