class Solution {
	class Node {
		char c;

		Node[] nL = new Node[26];

		boolean isWord;

		public void addNode(String s, int n){
			if (n == s.length()) isWord = true;
			else {
				if (nL[s.charAt(n) - 'a'] == null){
					nL[s.charAt(n) - 'a'] = new Node();
					nL[s.charAt(n) - 'a'].c = s.charAt(n);
				}
				nL[s.charAt(n) - 'a'].addNode(s, n + 1);
			}
		}

		public String getWord(String s, int n){
			if (isWord) return s.substring(0, n);
			if (n == s.length()) return s;

			if (nL[s.charAt(n) - 'a'] == null) return s;
			return nL[s.charAt(n) - 'a'].getWord(s, n + 1);
		}
	}

	public String replaceWords(List<String> dict, String sentence) {
		if (sentence.length() == 0) return ""; 
		Node root = new Node();
		for (String s: dict) root.addNode(s, 0);

		String[] sen = sentence.split(" ");
		StringBuilder sb = new StringBuilder();

		for (String s: sen){
			sb.append(root.getWord(s, 0));
			sb.append(" ");
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}
