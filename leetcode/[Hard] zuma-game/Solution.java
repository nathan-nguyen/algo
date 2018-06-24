class Solution {
	private Map<String, Integer> map;
	// R','Y','B','G','W'
	public int findMinStep(String board, String hand) {
		if (board.length() == 0) return 0;

		map = new HashMap<>();

		int[] hold = new int[5];

		for (int i = 0; i < hand.length(); ++i) ++hold[getIndex(hand.charAt(i))];

		return findMinStep(trim(board + '#'), hold);
	}

	public int findMinStep(String board, int[] hand){
		if (board.length() == 1) return 0;

		if (map.containsKey(board)) return map.get(board);

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < board.length(); ++i){
			if (board.charAt(i) != board.charAt(i - 1)){
				int index = getIndex(board.charAt(i - 1));
				if (hand[index] == 0) continue;

				--hand[index];
				int result = findMinStep(trim(board.substring(0, i) + board.charAt(i - 1) + board.substring(i)), hand); 
				++hand[index];

				if (result != -1) min = Math.min(min, result + 1);
			}
		}
		
		int ans = min == Integer.MAX_VALUE ? -1 : min;
		map.put(board, ans);
		return ans;
	}

	private String trim(String board){
		if (board.length() == 1) return "#";
		StringBuilder sb = new StringBuilder();
		sb.append(board.charAt(0));

		int count = 1;
		boolean found = false;
		for (int i = 1; i < board.length(); ++i){
			if (board.charAt(i) == board.charAt(i - 1)) ++count;
			else {
				if (count > 2) {
					sb.setLength(sb.length() - count);
					found = true;
				}
				count = 1;
			}
			sb.append(board.charAt(i));
		}

		String result = sb.toString();
		return found ? trim(result) : result;	
	}

	private int getIndex(char c){
		switch (c) {
			case 'R' : return 0;
			case 'Y' : return 1;
			case 'B' : return 2;
			case 'G' : return 3;
			case 'W' : return 4;
		}
		return -1;
	}
}
