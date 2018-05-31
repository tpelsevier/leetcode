class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //Build Graph
        Map<String,HashSet<String>> graph = new HashMap<>();
        for(List<String> account: accounts){ //O(NM)
            String firstEmail = account.get(1);
            for(int i = 1;i < account.size();i++){
                String email = account.get(i);
                if(!graph.containsKey(email)){
                    graph.put(email,new HashSet<String>());
                }
                graph.get(email).add(firstEmail);
                graph.get(firstEmail).add(email);
            }
        }
        HashSet<String> visited = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for(List<String> account: accounts){
            String email = account.get(1);
            if(!visited.contains(email)){
                List<String> one = new ArrayList<>();
                bfs(graph,visited,email,one);
                //dfs(graph,visited,email,one);
                Collections.sort(one);
                one.add(0,account.get(0));
                ans.add(one);
            }
        }
        return ans;
    }
    //DFS Traversal O(V+E)
    private void dfs(Map<String,HashSet<String>> graph, HashSet<String> visited, String email, List<String> ans){
        ans.add(email);
        visited.add(email);
        HashSet<String> next = graph.get(email);
        for(String n: next){
            if(!visited.contains(n)){
                dfs(graph,visited,n,ans);
            }
        }
    }
    //BFS Traversal O(V+E)
    private void bfs(Map<String,HashSet<String>> graph, HashSet<String> visited, String start, List<String> ans){
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty()){
            String email = queue.poll();
            ans.add(email);
            for(String next: graph.get(email)){
                if(visited.add(next)){
                    queue.offer(next);
                }
            }
        }
    }
}
