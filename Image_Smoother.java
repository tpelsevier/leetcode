//Time O(N*M) Space O(1)
class Solution {
    public int[][] imageSmoother(int[][] M) {
        if(M == null || M.length == 0) return new int[0][0];
        int m = M.length, n = M[0].length;
        int[][] result = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n; j++){
                result[i][j] = getAverage(i,j,M);
            }
        }
        return result;
    }
    private int getAverage(int x, int y, int[][] M){
        int count = 0, sum = 0;
        for(int i = x == 0?0:x-1;i<= (x== M.length-1?x:x+1);i++){
            for(int j = y == 0? 0:y-1;j<= (y == M[0].length-1?y:y+1);j++){
                sum += M[i][j];
                count++;
            }
        }
        return sum / count;
    }
}
