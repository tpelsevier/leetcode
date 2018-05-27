//Time O(V+E) Space O(V+E)
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visted = new HashSet<>();
        visted.add(0);
        while(!queue.isEmpty()){
            List<Integer> keys = rooms.get(queue.poll());
            for(int key: keys){
                if(visted.add(key)){
                    queue.offer(key);
                }
            }
        }
        return visted.size() == rooms.size();
    }
}
