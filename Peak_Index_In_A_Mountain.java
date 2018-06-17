//Time O(N)  Space O(1)
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        for(int i = 1; i < A.length-1;i++){
            if(A[i] > A[i-1] && A[i] > A[i+1]) return i;
        }
        return -1;

    }
}

//Time O(N) Space O(N)

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 1; i < n-1 ; i++){
            if(A[i] > A[i-1])left[i] = left[i-1]+1;
        }
        int res = 0;
        int max = 0;
        for(int i = n-2;i >= 1; i--){
            if(left[i] != 0 && A[i] > A[i+1]){
                right[i] = right[i+1]+1;
                int total = right[i] + left[i];
                if(total > max) res = i;
            }
        }
        return res;

    }
}
