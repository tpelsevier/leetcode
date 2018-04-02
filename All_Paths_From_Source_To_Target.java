//Time O(N * M) Space O(N) 
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph,0,new ArrayList<Integer>(){{add(0);}});
        return res;
    }
    private void dfs(int[][] graph, int next, List<Integer> path){
        if(next == graph.length-1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int n: graph[next]){
            path.add(n);
            dfs(graph,n,path);
            path.remove(path.size()-1);
        }
    }
}
