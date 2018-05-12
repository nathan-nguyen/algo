import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] a = new String[n];

		for (int  i = 0; i < n; ++i) a[i] = in.next();

		char[] first = a[0].toCharArray();
		if (first[0] == '?') first[0] = '1';
		
		for (int i = 1; i < a[0].length(); ++i){
			if (first[i] == '?') first[i] = '0';
		}
		a[0] = new String(first);

		for (int i = 1; i < n; ++i){
			String result = minNumber(a[i], a[i-1]);
			if (result.length() == 0){
				System.out.println("NO");
				return;
			}
			a[i] = result;
		}

		System.out.println("YES");
		for (int i = 0; i < n; ++i) System.out.println(a[i]);
	}

	// Template and previous string s
	private String minNumber(String t, String s){
		if (t.length() < s.length()) return "";

		if (!t.contains("?")){
			if (Integer.parseInt(t) <= Integer.parseInt(s)) return "";
			else return t;
		}

		char[] c = t.toCharArray();
		
		if (t.length() > s.length()){
			if (c[0] == '?') c[0] = '1';

			for (int i = 1; i < t.length(); ++i){
				if (c[i] == '?') c[i] = '0';
			}
			return new String(c);
		}

		int greaterDigit = -1;
		int lesserDigit = -1;
		for (int i = 0; i < t.length(); ++i){
			if (c[i] == '?' || c[i] == s.charAt(i)) continue;
			if (c[i] > s.charAt(i)) greaterDigit = i;
			else lesserDigit = i;
			break;
		}

		if (greaterDigit >= 0){
			for (int i = 0; i < t.length(); ++i){
				if (c[i] == '?') {
					if (i < greaterDigit) c[i] = s.charAt(i);
					else c[i] = '0';
				}
			}
			return new String(c);
		}
		else if (lesserDigit >= 0) {
			for (int i = lesserDigit + 1; i < t.length(); ++i) {
				if (c[i] == '?') c[i] = '0';
			}
		}

		int lower = 0;
		// Question mark count
		int count = 0;
		for (int i = 0; i < t.length(); ++i){
			if (c[i] == '?') {
				lower = lower * 10 + (s.charAt(i) - '0');
				++count;
			}
		}

		String sub = String.valueOf(lower + 1);

		if (sub.length() > count) return "";
		count = sub.length() - 1;
		for (int i = t.length() - 1; i >=0; --i){
			if (c[i] == '?') {
				if (count >= 0) c[i] = sub.charAt(count--);
				else c[i] = '0';
			}
		}
		return new String(c);
	}
}
