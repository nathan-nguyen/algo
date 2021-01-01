class Solution {
	public int getMaxRepetitions(String s1, int a, String s2, int b) {
		if (a <= 0) return 0;

		// count[i][0] - repeatTime; count[i][1] - next secondPosition;
		int[][] count = new int[100][2];

		int secondPosition = 0, repeatTime = 0;
		int i = 0, k = 0;

		while (k == i) {
			++i;
			for (int j = 0; j < s1.length(); ++j) {
				if (s2.charAt(secondPosition) == s1.charAt(j)) {
					++secondPosition;
					if(secondPosition == s2.length()) {
						++repeatTime;
						secondPosition = 0;
					}
				}
			}

			if (i >= a) return repeatTime / b;

			for (k = 0; k < i && secondPosition != count[k][1]; ++k);

			count[i][0] = repeatTime;
			count[i][1] = secondPosition;
		}

		int interval = i - k;
		int repeatCount = (a - k) / interval;
		int repeatTimes = repeatCount * (count[i][0] - count[k][0]);
		int remainTimes = count[(a - k) % interval + k][0];
		return (repeatTimes + remainTimes) / b;
	}
}

