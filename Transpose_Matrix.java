//Time O(M*N) Space O(M*N)
class Solution {
    public int[][] transpose(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] res = new int[n][m];
        int row = 0, col = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0;j < m; j++) {
                res[i][j] = A[row][col];
                row++;
                if(row == m){
                    row = 0;
                    col++;
                }
            }
        }
        
        return res;
    }
}
