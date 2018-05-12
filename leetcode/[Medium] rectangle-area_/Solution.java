class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	int left = Math.max(A, C), bottom = Math.max(B, D);
	int right = Math.max(left, Math.min (E, G)), top = Math.max(bottom, Math.min(F, H));
        return (C - A) * (D - B) + (G - E) * (H - F) - (right - left) * (top - bottom);
    }
}
