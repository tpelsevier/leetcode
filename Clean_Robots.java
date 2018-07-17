/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
 //Time O(N^2) Space O(N^2)
class Solution {
    private int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private int[] turns = new int[]{0,1,2,3};
    public void cleanRoom(Robot robot) {
        HashSet<String> visited = new HashSet<String>(){{
            add(new String("0,0"));
        }};
        dfs(visited,0,0,robot);
    }
    private void dfs(HashSet<String> visited, int x, int y, Robot robot) {
        robot.clean();
        for(int i = 0; i < 4; i++) {
            if(i != 0) robot.turnRight();
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            if(visited.add(new String(nx+","+ny)) && robot.move()) {
                for(int j = 0; j < turns[i];j++) robot.turnLeft(); //Make sure the robot face the north
                dfs(visited,nx,ny,robot);
                for(int j = 0 ; j < turns[i];j++) robot.turnRight(); //Make sure the robot stays the same position when last step reach current step
                //Coming back face toword the direction from last standing point
                robot.turnRight();robot.turnRight();
                robot.move();
                robot.turnRight();robot.turnRight();
            }
        }
        robot.turnRight();
    }
}
