//Time O((N*M)^2) Space O(N)
class Solution {
    int min = Integer.MAX_VALUE;
    int[][] dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
    int bn = 0;

    public int shortestDistance(int[][] grid) {
        for(int i = 0;i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1) bn ++;
            }
        }
        for(int i = 0; i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 0){
                    bfs(new int[]{i,j},grid);
                }
            }
        }
        return min == Integer.MAX_VALUE? -1:min;
    }
    private void bfs(int[] pos, int[][] grid){
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dq.offer(pos);
        int step = 1, total = 0;
        int remain = bn;
        visited[pos[0]][pos[1]] = true;
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i = 0;i<size;i++){
                int[] curr = dq.poll();
                int r = curr[0];
                int c = curr[1];
                for(int [] dir: dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] == 2 || visited[nr][nc] == true) continue;
                    if(grid[nr][nc] == 1) {
                        total += step;
                        remain --;
                    }else{
                        dq.offer(new int[]{nr,nc});
                    }
                    visited[nr][nc] = true;
                }
            }
            step++;
        }
        if(remain == 0) min = Math.min(min,total);
    }
}
//Time O(M*N) Space O(1)
class Solution {
    int[][] dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
    public int shortestDistance(int[][] grid) {
        int[][] nums = new int[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    bfs(new int[]{i,j},grid,nums,count++);
                }
            }
        }
        int min = Integer.MIN_VALUE;
        for(int i = 0; i< grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] < 0 && nums[i][j] == count) {
                    min = Math.max(min,grid[i][j]);
                }
            }
        }
        return min == Integer.MIN_VALUE? -1:-min;
    }
    private void bfs(int[] pos, int[][] grid, int[][] nums,int count){
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dq.offer(pos);
        int step = -1;
        visited[pos[0]][pos[1]] = true;
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i = 0;i<size;i++){
                int[] curr = dq.poll();
                int r = curr[0];
                int c = curr[1];
                for(int [] dir: dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] > 0 || visited[nr][nc] == true) continue;
                    if(grid[nr][nc] == 0 && nums[nr][nc] < count) continue;
                    visited[nr][nc] = true;
                    nums[nr][nc]++;
                    grid[nr][nc]+=step;
                    dq.offer(new int[]{nr,nc});

                }
            }
            step--;
        }
    }
}
