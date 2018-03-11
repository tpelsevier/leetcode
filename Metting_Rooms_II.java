/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 //Time O(NlogN) space O(N)
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals,(a,b)->a.start-b.start); //Get the meeting starts earliest
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.end- b.end); //Get the Metting that ends earliest
        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length;i++){
            Interval in = pq.poll();
            if(intervals[i].start >= in.end){
                in.end = intervals[i].end;
            }else{
                pq.offer(intervals[i]);
            }
            pq.offer(in);
        }
        return pq.size();
    }
}
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 //Time O(NlogN) space O(N)
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        int n = intervals.length;
        int[] s = new int[n];
        int[] e= new int[n];
        for(int i = 0; i < n ; i++){
            s[i] = intervals[i].end;
            e[i] =intervals[i].end;
        }
        Arrays.sort(s);
        Arrays.sort(e);
        int count = 0;
        int index = 0;
        for(int i = 0; i < intervals.length;i++){
            if(start[i] < end[index]) count++;
            else index++; //Keep track of the end time of a meeting
        }
        return count;
    }
}
