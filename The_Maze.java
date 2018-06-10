//DFS Time O(M*N) Space O(M*N)
class Solution {
    int[][] dirs = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length;
        for(int[] dir: dirs){
            if(dfs(dir,maze,start,dest,new boolean[m][n])) return true;
        }
        return false;
    }
    private boolean dfs(int[] dir, int[][] maze, int[] start,int[] dest, boolean[][] visited){
        int x = start[0], y = start[1];
        while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0){
            x += dir[0];
            y += dir[1];
        }
        x-=dir[0];
        y-=dir[1];
        if(visited[x][y]) return false;
        visited[x][y] = true;
        if(x == dest[0] && y == dest[1]) return true;
        for(int[] d:dirs){
            if(dir[0] + d[0] == 0 && dir[1] + d[1] == 0) continue;
            if(dfs(d,maze,new int[]{x,y},dest,visited)) return true;
        }
        return false;
    }
}
