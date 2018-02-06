//Time O(N^2) Space O(N^2)
class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new ArrayList<int[]>();
        int n = matrix.length,m = matrix[0].length;
        List<int[]> ls = new ArrayList<>();

        boolean[][] p = new boolean[n][m];
        boolean[][] a = new boolean[n][m];
        for(int i =0;i<m;i++){
            dfs(matrix,p,matrix[0][i],0,i);
            dfs(matrix,a,matrix[n-1][i],n-1,i);
        }
        for(int i = 0;i<n;i++){
            dfs(matrix,p,matrix[i][0],i,0);
            dfs(matrix,a,matrix[i][m-1],i,m-1);
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++)
                if(p[i][j] && a[i][j]) ls.add(new int[]{i,j});
        }
        return ls;

    }
    private int [][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    private void dfs(int[][] matrix,boolean[][] visted,int height,int x,int y){ //Height means previous cell
        if(x < 0 || y < 0 || x >=matrix.length || y >= matrix[0].length || visted[x][y] || matrix[x][y] < height) return; //if previous cell smaller than the current cell, then it is true
        visted[x][y] = true;
        for(int[] d: dirs)
            dfs(matrix,visted,matrix[x][y],x+d[0],y+d[1]);
    }
}
