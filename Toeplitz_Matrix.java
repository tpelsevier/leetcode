//Time O(M*N) Space O(1)
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0;i < matrix[0].length-1;i++){
            if(!isValid(0,i,matrix,matrix[0][i])) return false;
        }
        for(int i = 1; i < matrix.length-1; i++){
            if(!isValid(i,0,matrix,matrix[i][0])) return false;
        }
        return true;
    }
    private boolean isValid(int row, int col, int[][] matrix,int val){
        if(row >= matrix.length || col >= matrix[0].length) return true;
        if(matrix[row][col] != val) return false;
        return isValid(row+1,col+1,matrix,val);
    }
}

//Time O(MN) Space O(1)  4LINES

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0;i < matrix.length-1;i++){
            for(int j = 0; j < matrix[0].length-1;j++)
            if(matrix[i][j] != matrix[i+1][j+1]) return false;
        }
        return true;
    }
}
