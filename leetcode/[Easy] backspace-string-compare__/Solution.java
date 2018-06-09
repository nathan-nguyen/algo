class Solution {
	public boolean backspaceCompare(String S, String T) {
		return getFinal(S).toString().equals(getFinal(T).toString());
	}

	private StringBuilder getFinal(String s){
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); ++i){
                        if (s.charAt(i) == '#') sb.setLength(Math.max(sb.length() - 1, 0));
                        else sb.append(s.charAt(i));
                }

		return sb;
	}
}
