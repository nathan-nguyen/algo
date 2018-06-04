/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		if (intervals.size() == 0) return result;

		intervals.sort((u, v) -> u.start - v.start);

		int s = intervals.get(0).start;
		int e = intervals.get(0).end;

		for (int i = 1; i < intervals.size(); ++i){
			int s1 = intervals.get(i).start;
			int e1 = intervals.get(i).end;

			if (s1 > e){
				result.add(new Interval(s, e));
				s = s1;
				e = e1;
			}
			else e = Math.max(e, e1);
		}
		result.add(new Interval(s, e));

		return result;
	}
}
