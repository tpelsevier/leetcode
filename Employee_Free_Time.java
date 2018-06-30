/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
<<<<<<< HEAD
 //Time O(NlogN) Space O(N)
=======
 //Time O(NLogN) Space O(N)
>>>>>>> lc 759
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for(List<Interval> ls: schedule){
            for(Interval interval: ls){
                starts.add(interval.start);
                ends.add(interval.end);
            }
        }
        Collections.sort(starts);
        Collections.sort(ends);
        List<int[]> merge = new ArrayList<>();
        int size = starts.size();
        for(int i = 0, j = 0; i < size;i++){
            if(i == size-1 || ends.get(i) < starts.get(i+1)){
                merge.add(new int[]{starts.get(j),ends.get(i)});
                j = i+1;
            }
        }

        List<Interval> res = new ArrayList<>();
        for(int i = 1; i < merge.size();i++){
            int s = merge.get(i-1)[1], e = merge.get(i)[0];
            res.add(new Interval(s,e));
        }

        return res;
    }
}
