import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		while (n -- > 0) System.out.println(generate(in.next()));
	}

	private String generate(String s){
		for (int  i = s.length() - 2; i >= 0; --i){
			if (s.charAt(i) < s.charAt(i + 1)){
				char[] cl = s.substring(i + 1, s.length()).toCharArray();
				Arrays.sort(cl);
				char fc = s.charAt(i);
				int index = Arrays.binarySearch(cl, (char) (fc + 1));
				index = (index < 0) ? -index - 1 : index;
				char c = cl[index];
				cl[index] = fc;
				Arrays.sort(cl);
				return (s.substring(0, i) + c + (new String (cl)));
			}
		}
		return "no answer";
	}
}
