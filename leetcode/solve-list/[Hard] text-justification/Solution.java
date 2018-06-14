class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> line = new ArrayList<>();
		List<String> result = new ArrayList<>();

		int length = -1;
		for (String s: words){
			if (length + 1 + s.length() <= maxWidth) {
				line.add(s);
				length += s.length() + 1;
			}
			else {
				result.add(getLine(line, maxWidth - length, maxWidth));
				length = s.length();
				line.clear();
				line.add(s);
			}
		}
		StringBuilder sb = new StringBuilder();

		length = -1;
		for (String s: line){
			sb.append(s);
			sb.append(" ");
			length += s.length() + 1;
		}

		for (int i = sb.length(); i < maxWidth; ++i) sb.append(" ");
		sb.setLength(maxWidth);

		result.add(sb.toString());
		return result;
	}

	private String getLine(List<String> line, int maxSpace, int maxWidth){
		StringBuilder sb = new StringBuilder();

		int count = line.size() - 1;
		if (count == 0) {
			sb.append(line.get(0));
			while (sb.length() < maxWidth) sb.append(" ");
			return sb.toString();
		}
		for (String s: line){
			sb.append(s);
			if (count == 0) continue;
			int space = maxSpace / count + ((maxSpace % count > 0) ? 1 : 0);
			maxSpace -= space;
			--count;
			for (int i = 0; i < space + 1; ++i) sb.append(" ");
		}
		return sb.toString();
	}
}
