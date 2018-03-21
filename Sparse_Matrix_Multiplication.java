//Time O(RA*CB) Space O(1)
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, nA = A[0].length, nB = B[0].length;
        int[][] ans = new int[m][nB];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < nA;j++){
                if(A[i][j] != 0){
                    for(int f = 0; f <nB;f++){
                       if(B[j][f] != 0)ans[i][f] += A[i][j] * B[j][f];
                    }
                }
            }
        }
        return ans;
    }
}
