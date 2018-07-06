import java.util.Scanner;
import java.util.Queue;
import java.util.PriorityQueue; 

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		Queue<Integer> left = new PriorityQueue<>((u, v) -> Integer.compare(v, u));
		Queue<Integer> right = new PriorityQueue<>();

		while (n -- > 0){
			int k = in.nextInt();
			if (right.isEmpty() || left.isEmpty() || left.peek() <= k) right.offer(k);
			else left.offer(k);

			while (right.size() - left.size() > 1) left.offer(right.poll());
			while (left.size() > right.size()) right.offer(left.poll());

			if (left.size() == right.size()) System.out.println( (left.peek() + right.peek()) / (double) 2);
			else System.out.println((double) right.peek());
		}
	}
}
