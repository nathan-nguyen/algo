import java.util.Scanner;
import java.util.PriorityQueue;

public class Solution{
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long k = in.nextLong();


		long[] count = new long[10000001];
		long total = 0;	// Total of slices
		for (int i = 0; i < n; ++i){
			int sl = in.nextInt();
			total += sl;
			++count[sl];
		}

		if (total < k) {
			System.out.println(-1);
			return;
		}

		// Total of parts
		total = n;


		long local = 0;				// 1 - (min - 1)
		int min = 0;
		for (int i = 1; i < 10000001; ++i){
			if (count[i] > 0) local += count[i];
			if (total - local < k) {
				min = i;
				local -= count[min];
				break;
			}
		}

		for (int i = 10000000; i > 0; --i){
			if (count[i] > 0 && i > 2 * min){
				count[i / 2] += count[i];
				count[i - i / 2] += count[i];
				total += count[i];
				count[i] = 0;

				if (total - local >= k){
					while (total - local >= k ) local += count[min++];
					local -= count[--min];
				}

				continue;
			}
			else if (count[i] > 0 && i <= 2 * min){
				System.out.println(min);
				return;
			}
		}
	}
}
