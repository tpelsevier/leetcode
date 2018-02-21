//Time O(NK^2) Space(KNN)
class Solution {
    int [][] dirs = {{-1,2},{-1,-2},{1,2},{1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] board = new double[K+1][N][N];
        return helper(board,N,K,r,c) / Math.pow(8,K);
    }
    private double helper(double[][][] b, int N, int K, int r, int c){
        if(r <0 || c < 0 || r >= N || c >= N) return 0;
        if(K == 0) return 1;
        if(b[K][r][c] != 0) return b[K][r][c]; //Return how many possible ways start from this pos at K steps left
        for(int i = 0;i < 8; i++){
            b[K][r][c] += helper(b,N,K-1,r+dirs[i][0],c+dirs[i][1]);
        }
        return b[K][r][c];
    }
}
