//Time O(V+E) Space O(N)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] idr = new int[numCourses];
        for(int[] pres: prerequisites){
            idr[pres[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < idr.length;i++){
            if(idr[i] == 0) queue.offer(i); //Find how many prerequisites the course has
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for(int[] p: prerequisites){
                if(p[0] == pre) {
                    idr[p[1]]--;
                    if(idr[p[1]] == 0)
                    queue.offer(p[1]);
                }
            }
        }
        return numCourses <= 0;
    }
}
