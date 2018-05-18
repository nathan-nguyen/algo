import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		String s = in.next();
		char[] sc = s.toCharArray();

		int count = 0;
		for (int i = 0; i < sc.length; ++i){
			if (sc[i] != '9') ++count;
		}

		if (count <= k){
			for (int i = 0; i < sc.length; ++i) sc[i] = '9';
			System.out.println(new String(sc));
			return;
		}

		for (int i = 0; i < sc.length / 2; ++i){
			if (sc[i] != sc[sc.length - 1 - i]){
				if (k == 0) {
					System.out.println(-1);
					return;
				}
				char c = (char) Math.max(sc[i], sc[sc.length - 1 - i]);
				sc[i] = c;
				sc[sc.length - 1 - i] = c;
				--k;
			}
		}

		for (int i = 0; i < sc.length / 2 && k >= 0; ++i){
			if (sc[i] == '9') continue;
			if (s.charAt(i) != s.charAt(s.length() - 1 - i) && k >= 1) {
				sc[i] = '9';
                                sc[sc.length - 1 - i] = '9';
				--k;
			}
			else if (k >= 2){
				sc[i] = '9';
				sc[sc.length - 1 - i] = '9';
				k -= 2;
			}
		}

		if (k == 1 && sc.length % 2 == 1) sc[sc.length / 2] = '9';
		System.out.println(new String(sc));
	}
}
