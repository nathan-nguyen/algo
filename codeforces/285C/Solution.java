import java.util.Scanner;
import java.util.PriorityQueue;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; ++i) pq.add(in.nextInt());

		long result = 0;
		for (int i = 0; i < n; ++i) result += Math.abs(pq.poll() - i - 1);
		System.out.println(result);
	}
}
