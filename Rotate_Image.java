//Time O(N) Space O(1)

/*
  1,2,3
  4,5,6
  7,8,9
  After first for loop:
  1,4,7,
  2,5,8
  3,6,9
  After second for loop:
  7,1,4
  8,5,2
  9,6,3
*/
class Solution {
    public void rotate(int[][] matrix) {
        //rotate top right and bottom left
        for(int i = 0;i<matrix.length;i++){
            for(int j = i;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i<matrix.length;i++){
            int s = 0, e = matrix[0].length-1;
            while(s<e){
                int temp = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = temp;
                s++;
                e--;
            }
        }
    }
}
