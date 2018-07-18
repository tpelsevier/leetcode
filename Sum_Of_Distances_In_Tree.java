//Time O(N) Space O(N)
class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] ans = new int[N];
        int[] count = new int[N];
        HashSet<Integer>[] map = (HashSet<Integer>[])new HashSet[N];
        Arrays.fill(count,1);
        for(int[] edge: edges){
            if(map[edge[0]] == null) map[edge[0]] = new HashSet<>();
            if(map[edge[1]] == null) map[edge[1]] = new HashSet<>();
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        dfs(0,-1,ans,count,map);
        dfs1(0,-1,ans,count,map,N);
        return ans;
    }
    private void dfs(int node, int parent,int[] ans,int[] count,HashSet<Integer>[] map){
        if(map[node] == null) return;
        for(int next: map[node]){
            if(next == parent) continue;
            dfs(next,node,ans,count,map);
            count[node] += count[next];
            ans[node] += ans[next] + count[next];
        }
    }

    private void dfs1(int node, int parent,int[] ans, int[] count,HashSet<Integer>[] map, int N){
        if(map[node] == null) return;
        for(int next: map[node]){
            if(next == parent) continue;
            ans[next] = ans[node] - count[next] + N - count[next];
            dfs1(next,node,ans,count,map,N);
        }
    }
}
