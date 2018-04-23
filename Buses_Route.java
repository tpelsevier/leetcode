//Time O((V+E) + (M+N))  Space O(N*M)
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S==T) return 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visted = new HashSet<>();
        for(int i = 0; i < routes.length;i++){
            for(int j = 0;j < routes[i].length;j++){
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j],new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j],buses);
            }
        }
        int res = 0;

        queue.offer(S);
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            for(int i = 0; i < size;i++){
                int curr = queue.poll();
                ArrayList<Integer> buses = map.get(curr);
                for(int bus: buses){
                    if(!visted.add(bus)) continue;
                    for(int j = 0; j < routes[bus].length;j++){
                        if(routes[bus][j] == T) return res;
                        queue.offer(routes[bus][j]);
                    }
                }
            }
        }

        return -1;
    }
}
