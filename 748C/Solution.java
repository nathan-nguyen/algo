import java.util.Scanner;

public class Solution {

	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private boolean left = false, right = false, up = false, down = false;

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();

		int count = 1;
		for (int i = 0; i < n; ++i){
			switch (s.charAt(i)){
				case 'L':
					if (right) {
						++count;
						reset();
					}
					left = true;
					break;
				case 'D':
					if (up) {
						++count;
						reset();
					}
					down = true;
					break;
				case 'R':
					if (left) {
						++count;
						reset();
					}
					right = true;
					break;
				case 'U':
					if (down) {
						++count;
						reset();
					}
					up = true;
					break;
			}
		}
		System.out.println(count);
	}

	private void reset(){
		left = false;
		right = false;
		up = false;
		down = false;
	}

}
