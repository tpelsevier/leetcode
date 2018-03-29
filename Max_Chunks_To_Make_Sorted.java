/*
  [4,3,2,1,0]
  max = 4
  So we need to move until index of max to make the sort 

*/

//Time O(N) Space O(1)
class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int count = 0, max = 0;
        for(int i = 0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            if(max == i) count++;
        }
        return count;
    }
}
