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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length < 2) {
            return true;
        }
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        int len = intervals.length;
        for(int i = 1; i < len; i++) {
            if(intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
}
