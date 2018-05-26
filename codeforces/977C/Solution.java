import java.util.Scanner;
import java.util.PriorityQueue;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();

		int[] a = new int[n];
		int min = Integer.MAX_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<>((u,v)->v-u);
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
			pq.offer(a[i]);
			if (pq.size() > k) pq.poll();
			min = Math.min(min, a[i]);
		}

		if (k == 0) {
			System.out.println((min - 1 > 0) ? min - 1 : -1);
			return;
		}

		int count = 0;
		int result = pq.poll();
		for (int i = 0; i < n; ++i) {
			if (a[i] <= result) ++count;
		}

		System.out.println((count == k) ? result : -1);
	}
}
