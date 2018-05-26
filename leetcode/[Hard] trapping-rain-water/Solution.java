class Solution {
    public int trap(int[] h) {
        if (h.length == 0) return 0;

	int[] left = new int[h.length];
	int[] right = new int[h.length];

	for (int i = 0; i < h.length; ++i){
		if (i == 0) {
			left[i] = h[i];
			right[h.length - 1 - i] = h[h.length - 1 - i];
		}
		else {
			left[i] = Math.max(h[i], left[i-1]);
			right[h.length - 1 - i] = Math.max(h[h.length - 1 - i], right[h.length - 1 - i + 1]);
		}
	}

	int count = 0;

	for (int i = 0; i < h.length; ++i){
		count += Math.min(left[i], right[i]) - h[i];
	}

	return count;
    }
}

