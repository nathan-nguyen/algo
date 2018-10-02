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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (u, v) -> Integer.compare(u.start, v.start));

        Queue<Interval> queue = new PriorityQueue<>((u, v) -> Integer.compare(u.end, v.end));
        queue.offer(intervals[0]);

        for (int i = 1; i < intervals.length; ++i) {
            Interval e = queue.poll();
            if (e.end <= intervals[i].start) e.end = intervals[i].end;
            else queue.offer(intervals[i]);
            queue.offer(e);
        }
        return queue.size();
    }
}
