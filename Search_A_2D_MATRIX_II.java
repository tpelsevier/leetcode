//Time O(M*N) space O(1)
class Solution {
  //Brute Force
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int r = matrix.length-1,c = 0; r >= 0&& c <matrix[0].length;){
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) r--;
            else c++;
        }
        return false;
    }
}
//Time O(N) space O(1)
class Solution2 {
   // Start from bottom left corner
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int r = matrix.length-1,c = 0; r >= 0&& c <matrix[0].length;){
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) r--; //Since previous row is smaller then current row
            else c++; //Next col is bigger then current col
        }
        return false;
    }
}
