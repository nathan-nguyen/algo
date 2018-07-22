import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();

		int[] coin = new int[32];

		for (int i = 0; i < n; ++i) {
			int k = in.nextInt();
			int index = (int) (Math.log(k) / Math.log(2));
			++coin[index];
		}

		while (q -- > 0) {
			System.out.println(change(coin, in.nextInt()));
		}	
	}

	private int change(int[] origin, int value) {
		int[] coin = Arrays.copyOfRange(origin, 0, 32);
		int count = 0;
		for (int i = 0; i < 32; ++i) {
			if (((value >> i) & 1) == 1) {
				int total = 1 << i;
				for (int j = i; j >= 0; --j) {
					if (coin[j] == 0) continue;
					int val = 1 << j;
					if (total / val <= coin[j]) {
						count += total /val;
						coin[j] -= total / val;
						total = 0;
						break;
					}
					count += coin[j];
					total -= val * coin[j];
					coin[j] = 0;
				}
				if (total > 0) return -1;
			}
		}
		return count;
	}
}
