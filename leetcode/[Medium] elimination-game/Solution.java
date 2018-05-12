import java.util.List;
import java.util.ArrayList;

class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.lastRemaining(500000000));
	}

	public int lastRemaining(int n) {
		return lastRemaining(n, true);
	}

	public int lastRemaining(int n, boolean start){
		if (n == 1) return 1;
		if (n == 2) return start ? 2 : 1;
               
		if (start) return 2 * lastRemaining(n / 2, false);
		else return 2 * lastRemaining(n / 2, true) - (1 - ((n % 2 == 1) ? 1 : 0));
	}

}
