import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private List<Integer> pList = new ArrayList<>();
	private void solve() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		int[] nArr = new int[t];
		int max = 0;
		for (int i = 0; i < t; ++i) {
			nArr[i] = in.nextInt();
			max = Math.max(max, nArr[i]);
		}

		pList.add(2);
		for (int i = 3; i <= max; i += 2) {
			if (isPrime(i)) pList.add(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int k : nArr) {
			for (int i = 0; pList.get(i) * 2 <= k; ++i) {
				for (int j = 0; pList.get(i) * pList.get(j) <= k; ++j) {
					sb.append(pList.get(i));
					sb.append(" ");
					sb.append(pList.get(j));
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private boolean isPrime(int n) {
		for (int i = 0; pList.get(i) * pList.get(i) <= n; ++i) {
			if (n % pList.get(i) == 0) return false;
		}
		return true;
	}

}
