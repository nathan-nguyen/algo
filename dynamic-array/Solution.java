import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		Solution s = new Solution();
		s.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();

		int la = 0;
		ArrayList<ArrayList<Integer>> seq = new ArrayList<>();
		for (int i = 0; i < N; ++i) seq.add(new ArrayList<>());

		while (Q -- > 0){
			int c = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();

			if (c == 1) seq.get((x ^ la) % N).add(y);
			else {
				ArrayList<Integer> sqe = seq.get((x ^ la) % N);
				la = sqe.get(y % sqe.size());
				System.out.println(la);
			}
		}
	}
}
