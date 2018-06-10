//Time O(N) Space O(1)
class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int prev = -1, max = -1;
        for(int i = 0; i < n;i++){
            if(seats[i] == 1){
                if(prev != -1) max = Math.max(max,(i-prev)/2);
                else max = i;
                prev = i;
            }
        }
        max = Math.max(max,n-prev-1);
        return max;

    }
}
