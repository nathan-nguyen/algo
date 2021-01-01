class Solution {
	public List<String> readBinaryWatch(int num) {
		if (num > 8) return new ArrayList<>();

		List<String> l = new ArrayList<>();

		for (int i = 0; i < 12; ++i){
			for (int j = 0; j < 60; ++j){
				if (countBit(i) + countBit(j) == num){
					if (j < 10) l.add(i + ":0" + j);
					else l.add(i + ":" + j);
				}
			}
		}
		return l;
	}

	private int countBit(int n){
		int count = 0;
		for (int i = 0; i < 7; ++i){
			if (((n >> i) & 1) == 1) ++count;
		}
		return count;
	}
}
