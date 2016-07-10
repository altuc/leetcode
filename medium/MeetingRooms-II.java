/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length < 2) {
            return intervals.length;
        }
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((i1, i2) -> i1.end - i2.end);
        pq.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            Interval interval = pq.poll();
            if(intervals[i].start < interval.end) {
                pq.add(intervals[i]);
            } else {
                interval.end = intervals[i].end;
            }
            pq.add(interval);
        }
        return pq.size();
    }
}
