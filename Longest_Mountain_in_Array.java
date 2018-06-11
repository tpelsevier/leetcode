//Time (N^2) Space O(1)
class Solution {
    int max = 0;
    public int longestMountain(int[] A) {
        int len = A.length;
        for(int i = 1; i < len-1;i++){
            if(A[i-1] < A[i] && A[i+1] < A[i])
                max = Math.max(find(i, A,len), max);
        }
        return max;
    }
    private int find(int i,int[] A, int len){
        int prev = i-1, next = i+1;
        int pv = A[i], pn = A[i];
        int l = 1;
        while(prev >= 0 && A[prev] < pv){
            l++;
            pv = A[prev];
            prev--;
        }
        while(next < len && A[next] < pn){
            l++;
            pn = A[next];
            next++;
        }
        return l == 1? 0:l;
    }
}
//Time O(N) Space O(N)
class Solution {
    public int longestMountain(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 1;i<n-1;i++){
            if(A[i] > A[i-1]) left[i] = left[i-1]+1;
        }
        int max = 0;
        for(int i = n-2; i >= 1;i--){
            if(A[i] > A[i+1] ) right[i] = right[i+1]+1;
            if(left[i] > 0 &&right[i]> 0) max = Math.max(right[i]+left[i]+1,max);
        }
        return max;
    }
}
