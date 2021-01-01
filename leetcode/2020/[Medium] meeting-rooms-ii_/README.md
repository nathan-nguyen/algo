# meeting-rooms-ii

There is a really nice solution where we sort start points and end points.

This solution is similar to using Priority Queue approach, we merge the un-overlapping intervals.

The idea is that, we keep couting overlapping intervals and keep track of smallest end point. When overlapping does not happen, merge interval by increasing end point.

When start point less than end point, we keep the interval, else, we increase the end point. This is equivalent to interval merging. Starting points are not important after merging, we can ignore.

In the end, we only have overlapping intervals.

