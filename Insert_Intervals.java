/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 //Time O(NlogN) Space O(N)
class Solution {
    //1 2 6
    //3 5 9
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        int len = intervals.size();
        int[] start = new int[len];
        int[] end = new int[len];
        int mark = 0;
        for(int i = 0; i < intervals.size();i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> res = new ArrayList<>();
        for(int i = 0, j = 0;i<len;i++){
            if(i == len-1 || end[i] < start[i+1]){
                res.add(new Interval(start[j],end[i]));
                j = i+1;
            }
        }
        return res;
    }
}
