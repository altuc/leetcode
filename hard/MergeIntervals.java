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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.isEmpty()) {
            return res;
        }
        if(intervals.size() == 1) {
            return intervals;
        }
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end; 
        for(int i = 0; i < intervals.size() - 1; i++) {
            if(end < intervals.get(i + 1).start) {
                res.add(new Interval(start, end));
                start = intervals.get(i + 1).start;
                end = intervals.get(i + 1).end;
            } else {
                end = Math.max(end, intervals.get(i + 1).end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
