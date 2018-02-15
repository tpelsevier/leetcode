//Time O(N) space O(1)
/*

  if it is consecutive the gap will initial as 1,then 2 then 3
  plus the gap with the current count
  if consecutive is being interpreted the gap go back to one
  0,0,1,3,6,9
  1,2,3,4,5,6
*/
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int gap = 1;
        int count = 0;
        for(int i = 2;i < A.length;i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) count += gap;
            else gap = 0;
            gap++;
        }
        return count;
    }
}
