/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution1 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
            i++;
        }
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            intervals.remove(i);
        }
        intervals.add(i, newInterval);
        return intervals;
    }
}

public class Solution2 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            i++;
        }
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        res.add(newInterval);
        while(i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}
