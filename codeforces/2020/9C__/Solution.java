import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[512];
		for (int i = 0; i < 512; ++i) a[i] = Integer.parseInt(Integer.toBinaryString(i+1));
		for (int i = 0; i < 512; ++i) {
			if (a[i] > n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(512);
	}
}
