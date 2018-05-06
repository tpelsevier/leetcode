//Time O(N^2) Space O(N)
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxRows = new int[grid.length];
        int[] maxCols = new int[grid[0].length];
        for(int i = 0; i < grid.length;i++){
            int maxRow = 0;
            int maxCol = 0;
            for(int j = 0;j<grid[0].length;j++){
                maxRow = Math.max(maxRow,grid[i][j]);
                maxCol = Math.max(maxCol,grid[j][i]);
            }
            maxRows[i] = maxRow;
            maxCols[i] = maxCol;
        }
        int res = 0;
        for(int i = 0; i< grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                res += Math.min(maxRows[i],maxCols[j]) - grid[i][j];
            }
        }
        return res;
    }
}
