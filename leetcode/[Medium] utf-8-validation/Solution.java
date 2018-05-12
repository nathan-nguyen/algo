class Solution {
	public boolean validUtf8(int[] data) {
		if (data.length == 0) return true;

		for (int i = 0; i < data.length; ++i){
			int byteCount = getTotalByte(data[i]);
			if (byteCount < 0) return false;

			if (i + byteCount - 1 >= data.length) return false;
			while (--byteCount > 0) {
				++i;
				if (!isValidNextByte(data[i])) return false;
			}
		}
		return true;	
	}

	private int getTotalByte(int n){
		int result = 0;
		for (int i = 0; i < 4; ++i){
			if (((n >> (7 - i)) & 1) == 0) break;
			++result;
		}
		if (result == 1 || ((n >> (7 - result)) & 1) == 1) return -1;

		return (result == 0) ? 1 : result;
	}

	private boolean isValidNextByte(int n){
		return ((n >> 7) & 1) == 1 && ((n >> 6) & 1) == 0;
	}
}
