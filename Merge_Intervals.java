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
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n;i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> res = new ArrayList<>();
        for(int i = 0, j = 0;i<n;i++){
            if(i == n-1 || end[i] < start[i+1]){
                res.add(new Interval(start[j],end[i]));
                j= i+1;
            }
        }
        return res;
    }
}
