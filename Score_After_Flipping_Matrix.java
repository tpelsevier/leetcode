//Time O(N^2) Space O(1)
class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        for(int i = 0; i < m; i++){
            if(A[i][0] == 0){
                for(int j = 0; j < n; j++) A[i][j] = 1 -A[i][j];
            }
        }

        int res = 0, base = 1;
        for(int i = n-1; i >= 0 ;i--){
            int count = 0;
            for(int j = 0; j < m; j++){
                if(A[j][i] == 1) count++;
            }
            res += Math.max(m-count,count)*base;
            base *=2;
        }

        return res;
    }
}
