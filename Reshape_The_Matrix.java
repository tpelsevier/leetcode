//Time O(N*M) Space O(N)
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r * c > nums.length * nums[0].length || (r == nums.length && c == nums[0].length)) return nums;
        int[][] newShape = new int[r][c];
        int x = 0, y = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                newShape[i][j] = nums[x][y];
                if(y == nums[0].length -1){
                    x++;
                    y = -1;
                }
                y++;
            }
        }
        return newShape;
    }
}
