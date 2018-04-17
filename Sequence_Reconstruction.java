//Time O(V+E) Space O(N)
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();
        for(List<Integer>ls: seqs){
            for(int i = 0; i < ls.size();i++){
                int var = ls.get(i);
                graph.putIfAbsent(var,new ArrayList<>());
                indegree.putIfAbsent(var,0);
                if(i > 0){
                    graph.get(ls.get(i-1)).add(var);
                    indegree.put(var,indegree.get(var)+1);
                }
            }
        }
        if(indegree.size() != org.length) return false;
        Deque<Integer> dq = new ArrayDeque<>();
        for(Integer key: indegree.keySet()){
            if(indegree.get(key) == 0) dq.offer(key);
        }
        int ind = 0;
        while(!dq.isEmpty()){
            if(dq.size() > 1) return false;
            int var = dq.poll();
            if(org[ind++] != var)return false;
            for(int next: graph.get(var)){
                indegree.put(next,indegree.get(next)-1);
                if(indegree.get(next) == 0){
                    if(dq.size() == 1)return false;
                    dq.offer(next);
                }
            }
        }
        return ind == org.length;
    }
}
