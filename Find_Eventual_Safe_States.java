//Time O(N*(V+E)) Space O(1)
/*
COLORS 0 = UNVISTED
COLORS 1 = SAFE
COLORS 2 = UNSAFE
*/
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if(graph.length == 0 || graph == null) return res;
        int[] colors = new int[graph.length];
        for(int i = 0;i<graph.length;i++){
            if(graph[i].length == 0 || dfs(i,graph,colors)) res.add(i);
            colors[i] = graph[i].length == 0? 1:colors[i];
        }
        return res;
    }
    private boolean dfs(int s, int[][] graph, int[] colors){
        colors[s] = 2;
        for(int node: graph[s]){
            if(colors[node] == 1) continue;
            if(colors[node] == 2 || !dfs(node,graph,colors)) return false;
        }
        colors[s] = 1;
        return true;
    }
}
