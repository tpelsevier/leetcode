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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length == 0 || intervals.length == 1) return true;
        int[] s = new int[intervals.length];
        int[] e = new int[intervals.length];
        for(int i =0;i<intervals.length;i++){
            s[i] = intervals[i].start;
            e[i] = intervals[i].end;
        }
        Arrays.sort(s);
        Arrays.sort(e);
        for(int i = 1;i<intervals.length;i++){
            if(e[i-1] > s[i]) return false; //Means they are merged
        }
        return true;
    }
}
