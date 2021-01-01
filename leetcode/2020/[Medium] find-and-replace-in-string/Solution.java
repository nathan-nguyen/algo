class Solution {
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		int n = indexes.length;

		HashMap<Integer, String[]> map = new HashMap<>();

		for (int i = 0; i < n; ++i){
			if (!verify(S, indexes[i], sources[i])) continue;
			map.put(indexes[i], new String[]{sources[i], targets[i]});
		}

		List<Integer> l = new ArrayList<>(map.keySet());
		Collections.sort(l);

		StringBuilder sb = new StringBuilder();
		int start = 0;
		for (int e: l){
			String[] as = map.get(e);
			append(sb, S, start, e);
			sb.append(as[1]);
			start = e + as[0].length();
		}
		append(sb, S, start, S.length());

		return sb.toString();
	}

	private void append(StringBuilder sb, String s, int from , int end){
		for (int i = from; i < end; ++i) sb.append(s.charAt(i));
	}

	private boolean verify(String s, int pos, String source){
		if (pos < 0 || pos + source.length() - 1 >= s.length()) return false;

		for (int i = 0; i < source.length(); ++i){
			if (s.charAt(pos + i) != source.charAt(i)) return false;
		}

		return true;
	}
}
