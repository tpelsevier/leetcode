//Time O(N) Space O(K) Where K is the length of obstacles
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0;
        int x = 0, y = 0;
        HashSet<String> obs = new HashSet<>();
        for(int[] ob: obstacles) obs.add(ob[0] + "," + ob[1]); 
        int res = 0;
        for(int com: commands){
            if(com == -2){
                d = d == 0? 3:d-1;
            }
            else if(com == -1){
                d = d== 3?0: d+1;
            }else{
                while(com -- > 0){
                    x += dirs[d][0];
                    y += dirs[d][1];
                    if(obs.contains(x+","+y)){
                        x -= dirs[d][0];
                        y -= dirs[d][1];
                        break;
                    }
                    res = Math.max(x*x+y*y,res);
                }
            }
        }
        return res;
    }
}
