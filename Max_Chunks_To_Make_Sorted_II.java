/*
           [2,1,3,4,4]
maxLeft =  [2,2,3,4,4]
minRight = [1,1,3,4,4]
if maxLeft[i] <= minRight means that everything before i is not sorted,
since maxLeft is smaller than minRight, there will be a new piece of chunk
*/

//Time O(N) Space O(N)
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        maxLeft[0] = arr[0];
        for(int i = 1; i < n;i++){
            maxLeft[i] = Math.max(maxLeft[i-1],arr[i]);
        }
        minRight[n-1] = arr[n-1];
        for(int i = n-2; i >= 0;i--){
            minRight[i] = Math.min(minRight[i+1],arr[i]);
        }
        int count =0;
        for(int i = 0;i < n-1; i++){
            if(maxLeft[i] <= minRight[i+1]) count++;
        }
        return count+1;
    }
}
