//Time O(LogN + N) Space O(1)
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        //Sort if the end point is the same, see whose start point is greater;
        //Else see if who has smaller end point
        Arrays.sort(intervals, (a,b) ->
                            a[1] == b[1]? b[0] - a[0]:a[1] - b[1]);
        //Largest represents current largest value,
        //Second represents second largest value;
        int count = 0, largest = -1, second = -1;
        for(int[] interval: intervals){
            int start = interval[0], end = interval[1];
            boolean smallerThanLargest = (start <= largest);
            boolean smallerThanSecond = (start <= second);
            if(smallerThanLargest && smallerThanSecond) continue; //Means current interval is inside of previous intervals
            //If only smaller than largest, means this current start is greater than second, so just add one is enough
            count += (smallerThanLargest? 1:2);
            /*
                [1,5] [7,8] [5,10]
                in this case :
                So order will be [1,5] [7,8] [5,10]
                Then largest = 5 and second = 4;
                and 7 is greater than both, so second = 6 and largest = 7
                then 5,10 coming in;
                5 is smaller than 6
            */
            second = (smallerThanLargest? largest: end-1);
            largest = end;
        }
        return count;
    }
}
