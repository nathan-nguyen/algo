import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.lexicalOrder(5000000);
	}

	public List<Integer> lexicalOrder(int n) {
		ArrayList<Integer> l = new ArrayList<>();

		for (int i = 1; i < 10; ++i) {
			if (i > n) break;
			construct(l, i, n);
		}
		return l;
	}

	private void construct(List<Integer> l, int k, int n){
		l.add(k);

		for (int i = 0; i < 10; ++i){
			if (k * 10 + i > n) return;
			construct(l, k * 10 + i, n);
		}
	}
}
