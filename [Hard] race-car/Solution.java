class Solution {
    public int racecar(int target) {
        int[] step = new int[10001];
	
	step[1] = 1;
	for (int i = 3; i < 10001; i = i * 2 + 1) step[i] = step[i / 2] + 1;

	int last = 1;
	for (int i = 2; i < 10001; ++i) {
		if (i > target) return step[target];

		if (step[i] != 0) {
			last = i;
			continue;
		}

		if (step[last * 2 + 1 - i] > 0) {
			step[i] = Math.min(step[last] + 2 + step[i-last], 2 + step[last] + step[last * 2 + 1 - i]);
		}
		else step[i] = step[last] + 2 + step[i-last];
	}
	return step[target];
    }
}
