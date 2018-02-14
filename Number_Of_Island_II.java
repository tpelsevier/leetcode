//Time O(K log MN) space O(MN)
class Solution {
    int [][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int count = 0;
        List<Integer> res = new ArrayList<>();
        int[] roots = new int[m*n];
        Arrays.fill(roots,-1);
        for(int[] pos:positions){
            int p = n*pos[0]+pos[1];
            count ++;
            roots[p] = p;
            for(int[] dir: dirs){
                int px = pos[0] + dir[0];
                int py = pos[1] + dir[1];
                int p2 = px*n + py;
                if(px < 0 || py < 0 || px >= m || py >= n || roots[p2] == -1) continue;
                int p2r = findIsland(roots,p2);
                if(p != p2r){ //If roots of two pos is different
                    roots[p] = p2r; //Change pos root to the root of it's neightbor pos
                    p = p2r;  //change root pos to new roots pos
                    count --; //Count should minus 1
                }
            }
            res.add(count);
        }
        return res;

    }
    private int findIsland(int [] roots, int id){
        while(roots[id] != id){
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;

    }
}
