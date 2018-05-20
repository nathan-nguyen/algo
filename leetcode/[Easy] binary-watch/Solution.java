class Solution {
    public List<String> readBinaryWatch(int num) {
	ArrayList<String> l = new ArrayList<>();

        for (int i = 0; i < 12; ++i){
		for (int j = 0; j < 60; ++j){
			if (countLight(i) + countLight(j) == num){
				l.add(i + (j < 10 ? ":0" : ":") + j);
			}
		}
	}
	return l;
    }

	private int countLight(int n){
		int count = 0;

		for (int i = 0; i < 6; ++i){
			if (((n >> i) & 1) == 1) ++count;
		}
		return count;
	}
}
