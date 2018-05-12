class Solution {
	public String toGoatLatin(String os) {
		if (os.length() == 0) return "";

		String[] sl = os.split(" ");

		StringBuilder sb = new StringBuilder("a");
		StringBuilder r = new StringBuilder();

		for (String s: sl){
			int c = s.charAt(0);
			if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'o' || c == 'O' || c == 'u' || c == 'U' || c == 'i' || c == 'I'){
				r.append(s);
				r.append("ma");
				r.append(sb);
				r.append(" ");
			}
			else {
				r.append(s.substring(1, s.length()));
				r.append((char)c);
				r.append("ma");
				r.append(sb);
				r.append(" ");
			}
			sb.append("a");
		}
		r.setLength(r.length() - 1);
		return r.toString();
	}
}
