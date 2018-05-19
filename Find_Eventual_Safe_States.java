//Time O(N*(V+E)) Space O(1)
/*
COLORS 0 = UNVISTED
COLORS 1 = SAFE
COLORS 2 = UNSAFE
*/
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] colors = new int[graph.length];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < graph.length;i++){
            if(colors[i] == 2) continue;
            if(graph[i].length == 0 || colors[i] == 1) res.add(i);
            else{
                if(dfs(i,graph,colors)) res.add(i);
            }
        }
        return res;
    }
    private boolean dfs(int start, int[][] graph,int[] colors){
        if(colors[start] != 0) return colors[start] == 1;
        colors[start] = 2;
        for(int next: graph[start]){
            if(colors[next] == 1) continue;
            if(colors[next] == 2 || !dfs(next,graph,colors)) return false;
        }
        colors[start] =1;
        return true;
    }
}
