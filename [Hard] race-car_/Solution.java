class Solution {
    public int racecar(int target) {
        int[] step = new int[10001];
	boolean[] forward = new boolean[10001];
	
	step[1] = 1;
	for (int i = 3; i < 10001; i = i * 2 + 1) step[i] = step[i / 2] + 1;

	int last = 1;
	int lastReverse = -1;
	for (int i = 2; i < 10001; ++i) {
		if (i > target) {
			for (int j = 0; j <= target; ++j) System.out.println(j + " " + step[j] + " " + (forward[j] ? forward[j] : ""));
			return step[target];
		}

		if (step[i] != 0) {
			last = i;
			continue;
		}

		step[i] = step[last] + (forward[i-last] ? 1 : 2) + step[i-last];
		// forward[i-last] = true  -> forward[i] = false;
		// forward[i-last] = false -> forward[i] = false;
		System.out.println("-" + i + " " + last + " " + (i - last) + " " + step[i] + " " + (forward[i] ? true : "") + " ");

		int newStep = 2 + step[last] + step[last * 2 + 1 - i];

		// step[last * 2 + 1 - ] always > 0
		if (step[i] >= newStep) {
			step[i] = newStep;
			forward[i] = !forward[last * 2 + 1 - i];
			System.out.println("-" + i + " " + (last * 2 + 1) + " " + (last * 2 + 1 - i) + " " + step[i] + " " + (forward[i] ? true : ""));
		}


		if (lastReverse >= 0){
			newStep = 1 + step[lastReverse] + step[i - lastReverse];
			if ((step[i] > newStep) || (step[i] == newStep && forward[i - lastReverse])){
				step[i] = newStep;
				forward[i] = forward[i - lastReverse];
				System.out.println("-" + i + " " + lastReverse + " " + (i - lastReverse) + " " + step[i] + " " + (forward[i] ? true : ""));
				if (forward[i]) continue;
			}
		}

		if (forward[i]) {
			lastReverse = i;
			System.out.println(lastReverse);
		}
	}
	return step[target];
    }
}
