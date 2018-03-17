import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		int N = (int)(Math.pow(2, n));
		ArrayList<Integer>[] tree = new ArrayList[n+1];

		for (int i = 0; i < n + 1; ++i) tree[i] = new ArrayList<>();

		for (int i = 0; i < N; ++i) tree[n].add(in.nextInt());
	
		int max = N;
		for (int i = n-1; i >= 0; --i){
			for (int j = 0; j < max; j+=2){
				tree[i].add((n - i) % 2 == 1 ? tree[i+1].get(j) | tree[i+1].get(j+1) : tree[i+1].get(j) ^ tree[i+1].get(j+1));
			}
			max = max / 2;
		}

		StringBuilder result = new StringBuilder();
		while (m -- > 0){
			int index = in.nextInt() - 1;
			int value = in.nextInt();
			tree[n].set(index,value);

			for (int i = n - 1; i >= 0; --i){
				tree[i].set(index / 2, (n - i) % 2 == 1 ? tree[i+1].get(index / 2 * 2) | tree[i+1].get(index / 2 * 2 + 1) : tree[i+1].get(index / 2 * 2) ^ tree[i+1].get(index / 2 * 2 + 1));
				index /= 2;
			}
			result.append(tree[0].get(0));
			if (m > 0) result.append("\n");
		}
		System.out.println(result.toString());
	}
}
