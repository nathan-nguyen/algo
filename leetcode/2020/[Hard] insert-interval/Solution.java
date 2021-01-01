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
	public List<Interval> insert(List<Interval> iL, Interval nI) {
		List<Interval> l = new ArrayList<>();
		if (iL.size() == 0) {
			l.add(nI);
			return l;
		}

		int min = 0, max = 0;
		boolean merging = false;
		boolean merged = false;

		for (Interval itv: iL){
			if (merged) l.add(itv);
			else if (merging){
				if (itv.start <= max) max = Math.max(max, itv.end);
				else {
					merged = true;
					l.add(new Interval(min, max));
					l.add(itv);
				}
			}
			else if (itv.end < nI.start) l.add(itv);
			else {
				if (itv.start > nI.end) {
					l.add(nI);
					l.add(itv);
					merged = true;
				}
				else {
					merging = true;
					min = Math.min(nI.start, itv.start);
					max = Math.max(nI.end, itv.end);
				}
			}
		}

		if (!merged && merging) l.add(new Interval(min, max));
		if (!merged && !merging) l.add(nI);

		return l;
	}
}
