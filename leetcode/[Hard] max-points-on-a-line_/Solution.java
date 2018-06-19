/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
	public int maxPoints(Point[] p) {
		HashMap<String, Integer> map = new HashMap<>();

		int max = 0;
		for (int i = 0; i <  p.length; ++i){
			
			for (int j = i + 1; j < p.length; ++j){
				if (p[i].x == p[j].x && p[i].y == p[j].y) continue;
				String key = getKey(p[i], p[j]);
				int val = map.getOrDefault(key, 0) + 1;
				max = Math.max(max, val);
				map.put(key, val);
			}
		}
		return max;
	}

	private String getKey(Point p1, Point p2){
		int a = p2.y - p1.y;
		int b = p1.x - p2.x;
		int c = p1.x * p2.y - p2.x * p1.y;

		if (a < 0) {
			a *= -1;
			b *= -1;
			c *= -1;
		}
		else if (a == 0 && b < 0){
			b *= -1;
			c *= -1;
		}

		int u = gcd(Math.abs(a), Math.abs(b));
		int v = gcd(u, Math.abs(c));

		return (a / v) + "_" + (b / v) + "_" + (c / v);
	}

	private int gcd(int a, int b){
		if (a * b == 0) return a + b;

		if (a % b == 0) return b;
		if (b % a == 0) return a;

		return gcd(Math.min(a, b), Math.abs(a - b));
	}
}
