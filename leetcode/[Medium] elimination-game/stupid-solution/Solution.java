import java.util.List;
import java.util.ArrayList;

class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.lastRemaining(500000000));
	}

	public int lastRemaining(int n) {
		if (n == 1) return 1;
		List<Integer> l = new ArrayList<>();

		for (int i = 2; i <= n; i += 2) l.add(0, i);

		while (l.size() != 1){
			List<Integer> nl = new ArrayList<>();
			for (int i = 1; i < l.size(); i += 2) nl.add(0, l.get(i));
			l = nl;
		}

		return l.get(0);
	}
}
