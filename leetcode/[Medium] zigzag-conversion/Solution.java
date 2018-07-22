class Solution {
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;

		List<List<Character>> list = new ArrayList<>();
		for (int i = 0; i < numRows; ++i) list.add(new ArrayList<>());

		int position = 0;
		int direction = 1;

		for (int i = 0; i < s.length(); ++i) {
			list.get(position).add(s.charAt(i));
			position += direction;
			if (position == 0) direction = 1;
			else if (position == numRows - 1) direction = -1;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numRows; ++i) {
			for (char c: list.get(i)) sb.append(c);
		}
		return sb.toString();
	}
}
