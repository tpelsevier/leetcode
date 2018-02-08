//Time O(N*M) Space O(N*M)
class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m,n;
    public int cutOffTree(List<List<Integer>> forest) {
        m = forest.size();
        n=forest.get(0).size();
        //Used priority queue to sort the order for each tree height, and its location
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        for(int i = 0;i<forest.size();i++){
            for(int j = 0;j<forest.get(0).size();j++)
                if(forest.get(i).get(j) > 1)
                    pq.add(new int[]{i,j,forest.get(i).get(j)});
        }
        int [] start = new int[2];
        int sum = 0;
        while(!pq.isEmpty()){
            int[] des = pq.poll();
            int step = minStep(forest,start,des);//Get the min step
            if(step < 0) return -1; //Return -1 if step return less than 0
            sum += step;
            //Change the start point to the curr des
            start[0] = des[0];
            start[1] = des[1];
        }
        return sum;
    }
    private int minStep(List<List<Integer>> lists,int[] start, int[] des){
        int step = 0;
        boolean[][] visted = new boolean[m][n]; //This matrix is used to verify if target has been visted
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visted[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int size = queue.size();//Get the size of the current size in order to iterate through
            for(int i = 0;i<size;i++){
                int[] curr = queue.poll();
                if(curr[0] == des[0] && curr[1] == des[1]) return step;
                for(int[] d:dirs){
                    int nr = curr[0] + d[0]; //Next points row
                    int nc = curr[1] + d[1]; // Not points col
                    if(nr < 0 || nc <0 || nr >= m || nc >= n || visted[nr][nc] || lists.get(nr).get(nc) == 0) continue;
                    queue.add(new int[]{nr,nc});
                    visted[nr][nc] = true;
                }
            }
            step ++; //Add one step after last BFS
        }
        return -1;//If the queue can't go through it will return -1
    }

}
