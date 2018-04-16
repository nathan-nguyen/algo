class Solution {
    public int racecar(int target) {
        int[] step = new int[10001];
	boolean[] forward = new boolean[10001];
	
	step[1] = 1;
	for (int i = 3; i < 10001; i = i * 2 + 1) step[i] = step[i / 2] + 1;

	int last = 1;
	for (int i = 2; i < 10001; ++i) {
		if (i > target) return step[target];

		if (step[i] != 0) {
			last = i;
			continue;
		}

		step[i] = step[last] + (forward[i-last] ? 1 : 2) + step[i-last];
		if (step[last * 2 + 1 - i] > 0) {
			step[i] = Math.min(step[i], 2 + step[last] + step[last * 2 + 1 - i]);
			if (2 + step[last] + step[last * 2 + 1 - i] <= step[last] + 2 + step[i-last]){
				forward[i] = true;
			}
		}
	}
	return step[target];
    }
}
