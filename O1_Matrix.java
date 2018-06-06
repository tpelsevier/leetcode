//Time O((M*N) + (V+E)) Space O(N*M)
//BFS Solution
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir: dirs){
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n || matrix[nx][ny] <= matrix[curr[0]][curr[1]]+1) continue;
                queue.offer(new int[]{nx,ny});
                matrix[nx][ny] = matrix[curr[0]][curr[1]]+1;
            }
        }
        return matrix;
    }
//DFS Time O(MN) Space O(1)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                if(matrix[i][j] != 0){
                   dfs(i,j,matrix);
                }
            }
        }
        return matrix;
    }
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(int i, int j, int[][] matrix){
        int min = Integer.MAX_VALUE;
        for(int[] dir: dirs){
            int nx = dir[0] + i;
            int ny = dir[1] + j;
            if(nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix[0].length) continue;
            min = Math.min(min,matrix[nx][ny]+1); //Check the min
        }
        if(min != matrix[i][j]){ //If curr pos is not equal to min so assign the new min to curr pos
            matrix[i][j] = min;
            for(int[] dir: dirs){
                int nx = dir[0] + i;
                int ny = dir[1] + j;
                if(nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix[0].length) continue;
                dfs(nx,ny,matrix);
            }
        }
    }
}
