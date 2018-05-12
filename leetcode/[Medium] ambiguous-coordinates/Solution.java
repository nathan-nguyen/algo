import java.util.List;
import java.util.ArrayList;

class Solution {
	public List<String> ambiguousCoordinates(String s) {
		List<String> l = new ArrayList<>();
		if (s.length() < 3) return l;

		s = s.substring(1, s.length() - 1);

		for (int i = 0; i < s.length() - 1; ++i){
			List<String> left = generate(s.substring(0, i+1));
			List<String> right = generate(s.substring(i+1, s.length()));

			if (left.size() == 0 || right.size() == 0) continue;

			for (int u = 0; u < left.size(); ++u){
				for (int v = 0; v < right.size(); ++v){
					l.add("(" + left.get(u) + ", " + right.get(v) + ")");
				}
			}
		}

		return l; 
	}

	private List generate(String s){
		List<String> l = new ArrayList<>();
		
		for (int i = 0; i < s.length() - 1; ++i){
			String first = s.substring(0, i+1);

			if (first.length() > 1 && first.charAt(0) == '0') break;

			String second = s.substring(i+1, s.length());

			if (second.charAt(second.length() - 1) == '0') break;

			l.add(first + "." + second);
		}

		if (String.valueOf(Integer.parseInt(s)).equals(s)) l.add(s);

		return l;
	}
}
