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
